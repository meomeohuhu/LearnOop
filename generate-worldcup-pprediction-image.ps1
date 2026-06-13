Add-Type -AssemblyName System.Drawing
Add-Type -AssemblyName System.Windows.Forms

$ErrorActionPreference = "Stop"

$outPath = Join-Path $PSScriptRoot "worldcup-2026-predictions-updated.png"
$width = 1800
$height = 2680
$margin = 48

function New-Color([string]$hex) {
    return [System.Drawing.ColorTranslator]::FromHtml($hex)
}

function New-Font([float]$size, [System.Drawing.FontStyle]$style = [System.Drawing.FontStyle]::Regular) {
    return New-Object System.Drawing.Font("Arial", $size, $style, [System.Drawing.GraphicsUnit]::Pixel)
}

function Draw-Text($g, [string]$text, [float]$x, [float]$y, [float]$w, [float]$h, $font, $brush, $align = "Near", $line = "Center") {
    $fmt = New-Object System.Drawing.StringFormat
    $fmt.Trimming = [System.Drawing.StringTrimming]::EllipsisWord
    $fmt.FormatFlags = 0
    switch ($align) {
        "Center" { $fmt.Alignment = [System.Drawing.StringAlignment]::Center }
        "Far" { $fmt.Alignment = [System.Drawing.StringAlignment]::Far }
        default { $fmt.Alignment = [System.Drawing.StringAlignment]::Near }
    }
    switch ($line) {
        "Near" { $fmt.LineAlignment = [System.Drawing.StringAlignment]::Near }
        "Far" { $fmt.LineAlignment = [System.Drawing.StringAlignment]::Far }
        default { $fmt.LineAlignment = [System.Drawing.StringAlignment]::Center }
    }
    $rect = New-Object System.Drawing.RectangleF($x, $y, $w, $h)
    $g.DrawString($text, $font, $brush, $rect, $fmt)
    $fmt.Dispose()
}

function Fill-RoundedRect($g, $brush, [float]$x, [float]$y, [float]$w, [float]$h, [float]$r) {
    $path = New-Object System.Drawing.Drawing2D.GraphicsPath
    $d = $r * 2
    $path.AddArc($x, $y, $d, $d, 180, 90)
    $path.AddArc($x + $w - $d, $y, $d, $d, 270, 90)
    $path.AddArc($x + $w - $d, $y + $h - $d, $d, $d, 0, 90)
    $path.AddArc($x, $y + $h - $d, $d, $d, 90, 90)
    $path.CloseFigure()
    $g.FillPath($brush, $path)
    $path.Dispose()
}

$rows = @(
    @{ Date="11/06"; Match="Mexico - Nam Phi"; Stadium="Mexico City"; Score="2-0 KQ"; Reason="Chủ nhà, Azteca, Mexico kiểm soát tốt hơn" },
    @{ Date="12/06"; Match="Hàn Quốc - Czechia"; Stadium="Guadalajara"; Score="1-1"; Reason="Son/Lee Kang-in đối đầu bóng bổng Czechia" },
    @{ Date="12/06"; Match="Canada - Bosnia"; Stadium="Toronto"; Score="2-1"; Reason="Sân nhà Canada, Davies là điểm nổ" },
    @{ Date="12/06"; Match="Mỹ - Paraguay"; Stadium="SoFi"; Score="2-1"; Reason="Mỹ đủ quân; Paraguay phản công khó chịu" },
    @{ Date="13/06"; Match="Qatar - Thụy Sĩ"; Stadium="Santa Clara"; Score="0-2"; Reason="Thụy Sĩ kỷ luật, tuyến giữa chắc" },
    @{ Date="13/06"; Match="Brazil - Morocco"; Stadium="MetLife"; Score="2-1"; Reason="Brazil nhỉnh hơn, Morocco vẫn rất nguy hiểm" },
    @{ Date="13/06"; Match="Haiti - Scotland"; Stadium="Foxborough"; Score="0-1"; Reason="Scotland mạnh bóng chết và tranh chấp" },
    @{ Date="13/06"; Match="Australia - Thổ Nhĩ Kỳ"; Stadium="Vancouver"; Score="1-2"; Reason="Arda Güler/Çalhanoğlu tạo khác biệt" },
    @{ Date="14/06"; Match="Đức - Curaçao"; Stadium="Houston"; Score="3-0"; Reason="Chênh lệch chất lượng lớn; sân mái che ổn định" },
    @{ Date="14/06"; Match="Hà Lan - Nhật Bản"; Stadium="Arlington"; Score="1-1"; Reason="Nhật pressing tốt, Hà Lan thiếu độ sắc" },
    @{ Date="14/06"; Match="Bờ Biển Ngà - Ecuador"; Stadium="Philadelphia"; Score="1-1"; Reason="Cân bằng thể lực và kỷ luật phòng ngự" },
    @{ Date="14/06"; Match="Thụy Điển - Tunisia"; Stadium="Monterrey"; Score="1-0"; Reason="Gyökeres là điểm nổ, trận ít bàn" },
    @{ Date="15/06"; Match="Tây Ban Nha - Cape Verde"; Stadium="Atlanta"; Score="3-0"; Reason="Kiểm soát bóng vượt trội" },
    @{ Date="15/06"; Match="Bỉ - Ai Cập"; Stadium="Seattle"; Score="1-1"; Reason="De Bruyne vs Salah, thế trận cân bằng" },
    @{ Date="15/06"; Match="Saudi Arabia - Uruguay"; Stadium="Miami"; Score="0-2"; Reason="Uruguay pressing mạnh, thể lực tốt" },
    @{ Date="15/06"; Match="Iran - New Zealand"; Stadium="Inglewood"; Score="2-0"; Reason="Iran kinh nghiệm và chắc hơn" },
    @{ Date="16/06"; Match="Pháp - Senegal"; Stadium="MetLife"; Score="2-1"; Reason="Mbappé và chiều sâu đội hình Pháp" },
    @{ Date="16/06"; Match="Iraq - Na Uy"; Stadium="Foxborough"; Score="0-2"; Reason="Haaland/Ødegaard tạo khác biệt" },
    @{ Date="16/06"; Match="Argentina - Algeria"; Stadium="Kansas City"; Score="2-1"; Reason="Messi + bản lĩnh Argentina; Algeria phản công tốt" },
    @{ Date="16/06"; Match="Áo - Jordan"; Stadium="Santa Clara"; Score="2-0"; Reason="Pressing Rangnick áp đảo tuyến đầu" },
    @{ Date="17/06"; Match="Portugal - DR Congo"; Stadium="Houston"; Score="3-1"; Reason="Portugal nhiều phương án tấn công" },
    @{ Date="17/06"; Match="Anh - Croatia"; Stadium="Arlington"; Score="1-1"; Reason="Anh mạnh hơn, Croatia già dơ giữ nhịp" },
    @{ Date="17/06"; Match="Ghana - Panama"; Stadium="Toronto"; Score="2-1"; Reason="Ghana tốc độ biên và sức mạnh tốt hơn" },
    @{ Date="17/06"; Match="Uzbekistan - Colombia"; Stadium="Mexico City"; Score="0-2"; Reason="Luis Díaz và kinh nghiệm Colombia" },
    @{ Date="18/06"; Match="Czechia - Nam Phi"; Stadium="Atlanta"; Score="1-0"; Reason="Czechia lợi thế bóng bổng/set-piece" },
    @{ Date="18/06"; Match="Thụy Sĩ - Bosnia"; Stadium="Inglewood"; Score="2-1"; Reason="Thụy Sĩ ổn định hơn, Bosnia có kinh nghiệm" },
    @{ Date="18/06"; Match="Canada - Qatar"; Stadium="Vancouver"; Score="2-0"; Reason="Tốc độ Davies/David đánh vào khoảng trống" },
    @{ Date="18/06"; Match="Mexico - Hàn Quốc"; Stadium="Guadalajara"; Score="1-1"; Reason="Mexico khí thế chủ nhà, Hàn quen độ cao" },
    @{ Date="19/06"; Match="Mỹ - Australia"; Stadium="Seattle"; Score="2-0"; Reason="Seattle mát, thuận cho pressing của Mỹ" },
    @{ Date="19/06"; Match="Scotland - Morocco"; Stadium="Foxborough"; Score="0-1"; Reason="Morocco chín hơn về kỹ thuật" },
    @{ Date="19/06"; Match="Brazil - Haiti"; Stadium="Philadelphia"; Score="3-0"; Reason="Chênh lệch cá nhân lớn" },
    @{ Date="19/06"; Match="Türkiye - Paraguay"; Stadium="Santa Clara"; Score="1-1"; Reason="Türkiye sáng tạo, Paraguay phá nhịp tốt" },
    @{ Date="20/06"; Match="Hà Lan - Thụy Điển"; Stadium="Houston"; Score="1-1"; Reason="Hà Lan cầm bóng, Thụy Điển có Gyökeres" },
    @{ Date="20/06"; Match="Đức - Bờ Biển Ngà"; Stadium="Toronto"; Score="2-1"; Reason="Đức cấu trúc tốt hơn; CIV mạnh bóng hai" },
    @{ Date="20/06"; Match="Ecuador - Curaçao"; Stadium="Kansas City"; Score="2-0"; Reason="Ecuador phòng ngự chắc, pressing đều" },
    @{ Date="20/06"; Match="Tunisia - Nhật Bản"; Stadium="Monterrey"; Score="0-2"; Reason="Nhật xử lý nhanh và pressing tốt hơn" },
    @{ Date="21/06"; Match="Tây Ban Nha - Saudi Arabia"; Stadium="Atlanta"; Score="3-0"; Reason="Spain kéo giãn hai biên, áp đảo kiểm soát" },
    @{ Date="21/06"; Match="Bỉ - Iran"; Stadium="Inglewood"; Score="2-1"; Reason="De Bruyne tạo cơ hội; Iran mạnh cố định" },
    @{ Date="21/06"; Match="Uruguay - Cape Verde"; Stadium="Miami"; Score="2-0"; Reason="Uruguay pressing liên tục, va chạm tốt" },
    @{ Date="21/06"; Match="New Zealand - Ai Cập"; Stadium="Vancouver"; Score="0-2"; Reason="Salah và chuyển trạng thái của Ai Cập" }
)

$bmp = New-Object System.Drawing.Bitmap($width, $height)
$g = [System.Drawing.Graphics]::FromImage($bmp)
$g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
$g.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::ClearTypeGridFit

$bgRect = New-Object System.Drawing.Rectangle(0, 0, $width, $height)
$bgBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush($bgRect, (New-Color "#06101f"), (New-Color "#102947"), 90)
$g.FillRectangle($bgBrush, $bgRect)
$bgBrush.Dispose()

$white = New-Object System.Drawing.SolidBrush(New-Color "#f7fbff")
$muted = New-Object System.Drawing.SolidBrush(New-Color "#b6c5d6")
$gold = New-Object System.Drawing.SolidBrush(New-Color "#f6c85f")
$red = New-Object System.Drawing.SolidBrush(New-Color "#cc2936")
$green = New-Object System.Drawing.SolidBrush(New-Color "#2dd4a7")
$linePen = New-Object System.Drawing.Pen((New-Color "#254967"), 2)
$thinPen = New-Object System.Drawing.Pen((New-Color "#1b3c58"), 1)

$titleFont = New-Font 44 ([System.Drawing.FontStyle]::Bold)
$subFont = New-Font 23
$smallFont = New-Font 19
$headerFont = New-Font 23 ([System.Drawing.FontStyle]::Bold)
$rowFont = New-Font 22
$rowBold = New-Font 23 ([System.Drawing.FontStyle]::Bold)
$scoreFont = New-Font 24 ([System.Drawing.FontStyle]::Bold)

$panelBrush = New-Object System.Drawing.SolidBrush(New-Color "#081827")
Fill-RoundedRect $g $panelBrush $margin 34 ($width - 2 * $margin) 190 18
$panelBrush.Dispose()

Draw-Text $g "DỰ ĐOÁN CẬP NHẬT WORLD CUP 2026 - VÒNG BẢNG" $margin 52 ($width - 2 * $margin) 56 $titleFont $white "Center"
Draw-Text $g "Cập nhật 12/06/2026 08:37 (giờ Việt Nam) | Lịch/sân đối chiếu nguồn chính thức | XI có thể đổi sát giờ" $margin 110 ($width - 2 * $margin) 34 $subFont $muted "Center"

$badgeBrush = New-Object System.Drawing.SolidBrush(New-Color "#1a2f44")
Fill-RoundedRect $g $badgeBrush 190 150 1420 58 10
$badgeBrush.Dispose()
Draw-Text $g "KẾT QUẢ ĐÃ XÁC NHẬN: MEXICO 2-0 NAM PHI" 205 153 1390 26 $headerFont $gold "Center"
Draw-Text $g "Nền phân tích: squad FIFA, sân, thời tiết, phong độ, lối chơi, bối cảnh" 205 181 1390 22 $smallFont $muted "Center"

$tableX = $margin
$tableY = 250
$tableW = $width - 2 * $margin
$rowH = 56
$colDate = 118
$colMatch = 390
$colStadium = 250
$colScore = 150
$colReason = $tableW - $colDate - $colMatch - $colStadium - $colScore

$hdrBrush = New-Object System.Drawing.SolidBrush(New-Color "#9e1525")
Fill-RoundedRect $g $hdrBrush $tableX $tableY $tableW 52 10
$hdrBrush.Dispose()
Draw-Text $g "Ngày" $tableX $tableY $colDate 52 $headerFont $white "Center"
Draw-Text $g "Trận đấu" ($tableX + $colDate) $tableY $colMatch 52 $headerFont $white "Center"
Draw-Text $g "Sân" ($tableX + $colDate + $colMatch) $tableY $colStadium 52 $headerFont $white "Center"
Draw-Text $g "Tỉ số" ($tableX + $colDate + $colMatch + $colStadium) $tableY $colScore 52 $headerFont $white "Center"
Draw-Text $g "Lý do chính" ($tableX + $colDate + $colMatch + $colStadium + $colScore) $tableY $colReason 52 $headerFont $white "Center"

$y = $tableY + 58
for ($i = 0; $i -lt $rows.Count; $i++) {
    $r = $rows[$i]
    $fillColor = if ($i % 2 -eq 0) { "#0d2135" } else { "#102943" }
    if ($r.Score -like "*KQ*") { $fillColor = "#12352e" }
    $rowBrush = New-Object System.Drawing.SolidBrush(New-Color $fillColor)
    $g.FillRectangle($rowBrush, $tableX, $y, $tableW, $rowH)
    $rowBrush.Dispose()
    $g.DrawRectangle($thinPen, $tableX, $y, $tableW, $rowH)

    Draw-Text $g $r.Date $tableX ($y + 1) $colDate ($rowH - 2) $rowBold $gold "Center"
    Draw-Text $g $r.Match ($tableX + $colDate + 16) ($y + 1) ($colMatch - 24) ($rowH - 2) $rowBold $white "Near"
    Draw-Text $g $r.Stadium ($tableX + $colDate + $colMatch + 12) ($y + 1) ($colStadium - 24) ($rowH - 2) $rowFont $muted "Near"

    $scoreX = $tableX + $colDate + $colMatch + $colStadium + 18
    $scoreBrush = New-Object System.Drawing.SolidBrush($(if ($r.Score -like "*KQ*") { New-Color "#166f54" } else { New-Color "#172338" }))
    Fill-RoundedRect $g $scoreBrush $scoreX ($y + 9) ($colScore - 36) 38 9
    $scoreBrush.Dispose()
    Draw-Text $g $r.Score $scoreX ($y + 8) ($colScore - 36) 38 $scoreFont $(if ($r.Score -like "*KQ*") { $green } else { $gold }) "Center"

    Draw-Text $g $r.Reason ($tableX + $colDate + $colMatch + $colStadium + $colScore + 18) ($y + 1) ($colReason - 30) ($rowH - 2) $rowFont $white "Near"

    $x1 = $tableX + $colDate
    $x2 = $x1 + $colMatch
    $x3 = $x2 + $colStadium
    $x4 = $x3 + $colScore
    foreach ($x in @($x1, $x2, $x3, $x4)) {
        $g.DrawLine($thinPen, $x, $y, $x, $y + $rowH)
    }
    $y += $rowH
}

$footerY = $y + 24
$footBrush = New-Object System.Drawing.SolidBrush(New-Color "#081827")
Fill-RoundedRect $g $footBrush $margin $footerY ($width - 2 * $margin) 92 14
$footBrush.Dispose()
Draw-Text $g "Ghi chú: Dự đoán không phải cam kết kết quả. Đội hình xuất phát, chấn thương và thời tiết có thể thay đổi sát giờ bóng lăn." $margin ($footerY + 16) ($width - 2 * $margin) 28 $subFont $white "Center"
Draw-Text $g "Bản cập nhật ưu tiên tính hợp lý: sức mạnh đội hình, sân thi đấu, điều kiện khí hậu, phong độ cầu thủ chủ chốt và bối cảnh ngoài sân." $margin ($footerY + 48) ($width - 2 * $margin) 28 $smallFont $muted "Center"

$g.DrawRectangle($linePen, $margin, 34, ($width - 2 * $margin), ($footerY + 92 - 34))

$bmp.Save($outPath, [System.Drawing.Imaging.ImageFormat]::Png)

$g.Dispose()
$bmp.Dispose()
$white.Dispose()
$muted.Dispose()
$gold.Dispose()
$red.Dispose()
$green.Dispose()
$linePen.Dispose()
$thinPen.Dispose()
$titleFont.Dispose()
$subFont.Dispose()
$smallFont.Dispose()
$headerFont.Dispose()
$rowFont.Dispose()
$rowBold.Dispose()
$scoreFont.Dispose()

Write-Output $outPath

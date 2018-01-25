package com.example.tmd.displayhtmlintextview;

/**
 * Created by tmd on 21/04/2017.
 */

public class textInHTML {
    /*
        tags supported:
        <a href="...">: The href attribute specifies the URL of the page the link goes to.
                <p>An absolute URL: <a href="https://www.w3schools.com">W3Schools</a></p>

        <b>: The <b> tag specifies bold text.
                <b>This text is bold.</b>

        <big>: The <big> tag defines bigger text.
                <p>HTML <big><big><big><big>Big</big></big></big></big> Formatting</p>

        <small>: The <small> tag defines smaller text (and other side comments).
                <p>HTML <small><small><small>Small</small></small></small> Formatting</p>

        <blockquote>: The <blockquote> tag specifies a section that is quoted from another source
                        <blockquote cite="http://www.worldwildlife.org/who/index.html">
                        For 50 years, WWF has been protecting the future of nature. The world's leading conservation organization, WWF works in 100 countries and is supported by 1.2 million members in the United States and close to 5 million globally.
                        </blockquote>
        <br> or <br/>: The <br> tag inserts a single line break
                <p>To break lines<br>in a text,<br/>use the br element.</p>

        <cite>: The <cite> tag defines the title of a work
                <p><cite>The Scream</cite> by Edward Munch. Painted in 1893.</p>

        <dfn>: The <dfn> tag represents the defining instance of a term in HTML.
                <p><dfn>HTML</dfn> is the standard markup language for creating web pages.</p>

        <em>: The <em> tag is a phrase tag. It renders as emphasized text.
                <p><em>This text is emphasized.</em></p>

        <font color="...">: The color attribute specifies the color of the text inside a <font> element.
                <font color="red">This text is red</font>

        <font face="...">: The face attribute specifies the font of the text inside a <font> element.
                <p><font face=\"Times New Roman\">This text is Times New Roman.</font></p>

        <h1>: The <h1> to <h6> tags are used to define HTML headings. <h1> defines the most important heading.
        <h2>
        <h3>
        <h4>
        <h5>
        <h6>: <h6> defines the least important heading.
                <h1>This text is the most important heading</h1>
                <h6>This text is the least important heading</h6>

        <i>: The content of the <i> tag is usually displayed in italic
                <p><i>This text is italic.</i></p>

        <img src="...">

        <p>: The <p> tag defines a paragraph.
                <p>This text is normal.</p>

        <strong>: The <strong> tag is a phrase tag. It defines important text.
                <p><strong>This text is strong.</strong></p>

        <sub>: The <sub> tag defines subscript text.
            Subscript text appears half a character below the normal line,
            and is sometimes rendered in a smaller font.
            Subscript text can be used for chemical formulas, like H2O.
                <p>This is <sub>subscripted</sub> text.</p>

        <sup>: The <sup> tag defines superscript text.
            Superscript text appears half a character above the normal line,
            and is sometimes rendered in a smaller font.
            Superscript text can be used for footnotes, like WWW[1].
                <p>This is <sup>superscripted</sup> text.</p>

        <tt>: The <tt> tag defines teletype text (monospaced text).
                <p><tt>This text is monospaced text.</tt></p>

        <u>: The <u> tag specifies under line text.
                <p>This is a <u>parragraph</u>.</p>
     */
    public static String content ="<mark>This text is marked</mark>\n"+
            "<p>An absolute URL: <a href=\"https://www.w3schools.com\">W3Schools</a></p>" +
                    "<b>This text is bold.</b>" +
                    "<p>HTML <big><big><big><big>Big</big></big></big></big> Formatting</p>" +
                    "<p>HTML <small><small><small>Small</small></small></small> Formatting</p>" +
                    "<blockquote cite=\"http://www.worldwildlife.org/who/index.html\">" +
                    " For 50 years, WWF has been protecting the future of nature. The world's leading conservation organization, WWF works in 100 countries and is supported by 1.2 million members in the United States and close to 5 million globally." +
                    "</blockquote>" +
                    "<p>To break lines<br>in a text,<br/>use the br element.</p>" +
                    "<p><cite>The Scream</cite> by Edward Munch. Painted in 1893.</p>" +
                    "<p><dfn>HTML</dfn> is the standard markup language for creating web pages.</p>" +
                    "<p><em>This text is emphasized.</em></p>" +
                    "<p><font color=\"red\">This text is red</font></p>" +
                    "<p><font face=\"Times New Roman\">This text is Times New Roman.</font></p>" +
                    "<p><font face=\"Lucida Console\">This text is Lucida Console.</font></p>" +
                    "<p><font face=\"Arial\">This text is Arial.</font></p>" +
                    "<h1>This text is the most important heading</h1>" +
                    "<h6>This text is the least important heading</h6>" +
                    "<p><i>This text is italic.</i></p>" +
                    "<p>This is paragraph.</p>" +
                    "<p><strong>This text is strong.</strong></p>" +
                    "<p>This is <sub>subscripted</sub> text.</p>" +
                    "<p>This is <sup>superscripted</sup> text.</p>" +
                    "<p><tt>This text is teletype text.</tt></p>" +
                    "<p>This is a <u>parragraph</u>.</p>" +
                    "\n" +
                    "\n" +
                    "<p>This text is <big><big><big><big><font color=\"red\"><strong><i><u>tạp <sub>phí</sub> <sup>lù</sup>.</u></i></strong></font></big></big></big></big></p>";

    public static String content2 = "THIÊN NHAI TƯ QUÂN BẤT KHẢ VONG-<br/>\t\t\t\t\t\t   Chữ tình buộc lấy chữ sầu,<br/>Chân trời góc biển tìm đâu bây giờ<br/> <br/>Xuân du hạo đãng, thị niên niên hàn thực, lê hoa thời tiết.<br/>Bạch cẩm vô văn hương lạn mạn, ngọc thụ quỳnh bao đôi tuyết.<br/>Tĩnh dạ trầm trầm, phù quang ái ái, lãnh mạn dung dung nguyệt.<br/>Nhân gian thiên thượng, lạn ngân hà chiếu thông triệt.<br/>Hồn tự cô xạ chân nhân, thiên tư linh tú, ý khí thù cao khiết.<br/>Vạn nhị sâm sai thùy tín đạo, bất dữ quần phương đồng liệt.<br/>Hạo khí thanh anh, tiên tài trác lạc, hạ thổ nan phân biệt.<br/>Dao đài qui khứ, động thiên phương khán thanh tuyệt.<br/>Tiết trời lạnh hoa lê đang rộ,<br/>Khách nhàn du lãng đãng chơi xuân.<br/>Hương thơm bay tỏa không gian,<br/>Cành cây trắng xóa lộc non nở đầy.<br/>Ánh trăng lạnh canh khuya thanh tĩnh,<br/>Chiếu trên cao thấp thoáng sông ngân.<br/>Tâm tình một vẻ miên man,<br/>Trời cho tính khí cao sang vẻ người.<br/>Chen lẫn vẻ muôn hoa rực rỡ,<br/>Vẻ thanh cao vẫn tự vươn cao.<br/>Thanh anh trác lạc hơn người,<br/>Dẫu trong ngọc đá có chiều nọ kia.<br/>Dao đài ai kẻ đi về,<br/>Hương trời đôi lứa đã kề bên nhau.<br/>Bài từ \"Vô Tục Niệm\" này vốn là của một vị võ học danh gia, cũng là một đạo sĩ ở vào cuối đời Nam Tống họ Khưu tên Xứ Cơ, đạo hiệu Trường Xuân Tử. Ông là một trong Toàn Chân thất tử và là nhân vật xuất sắc của phái Toàn Chân. Trong \"Từ Phẩm\" đã bình về bài từ này như sau :<br/>\"Trường Xuân, người đời vẫn coi là một vị tiên, nên lời từ mới hay và xuất sắc đến thế\"<br/>Bài từ tuy nói về hoa lê, nhưng thật ra chính là để ca tụng một thiếu nữ xinh đẹp mặc áo trắng, coi nàng \"thực không phải người phàm, thiên tư linh tú, khí độ cao khiết\", lại nói nàng \"hạo khí thanh anh, tiên tài trác lạc\", \"bất dĩ quần phương đồng liệt\" (không giống như những người khác). Người con gái đẹp mô tả trong bài từ này, chính là truyền nhân của phái Cổ Mộ, Tiểu Long Nữ. Nàng vốn ưa mặc đồ trắng, chẳng khác gì gió thổi qua cây ngọc, đóa quỳnh nở trong tuyết, chỉ hiềm tính khí lạnh lùng, nên mới tả hình dung là \"lãnh mạn dung dung nguyệt\". Khưu Xứ Cơ tặng nàng ba chữ \"Vô Tục Niệm\" thật mười phần xác đáng.<br/>Trường Xuân Tử Khưu Xứ Cơ ở ngay bên cạnh nàng tại Chung Nam Sơn, một lần gặp mặt nên viết ra bài từ này. Lúc bấy giờ Khưu Xứ Cơ tạ thế đã lâu, Tiểu Long Nữ cũng đã làm vợ Thần Điêu đại hiệp Dương Quá. <br/>Trên sơn đạo núi Thiếu Thất, tỉnh Hà Nam, có một thiếu nữ, đang cúi đầu lẩm nhẩm bài từ này. Cô gái ước chừng mười tám, mười chín tuổi, mặc áo màu vàng nhạt, cưỡi một con lừa đen, đi chầm chậm lên núi, vừa đi vừa nghĩ thầm: \"Chỉ có người như Long tỉ tỉ mới xứng đáng lấy được chàng mà thôi\".<br/>Chữ \"chàng\" hiển nhiên là nói đến Thần Điêu đại hiệp Dương Quá. Cô gái lỏng dây cương, cứ để cho con lừa tự ý, thẳng đường lên núi. Một lúc lâu sau, cô lại lẩm bẩm: \"hoan lạc thú, ly biệt khổ, tựu trung cánh hữu si nhi nữ. Quân ứng hữu ngữ, diểu vạn lý tằng vân, thiên sơn mộ tuyết, chích ảnh hướng thùy khứ?\" <br/>Gặp nhau lòng những vui vầy,<br/>Xa nhau dạ những luống đầy khổ đau.<br/>Cõi tình mê đắm ai đâu?<br/>Chim kia thiếu bạn tiếng sầu lẻ loi.<br/>Từng mây muôn dặm xa xôi,<br/>Núi cao tuyết trắng nơi nơi cũng là.<br/>";
}
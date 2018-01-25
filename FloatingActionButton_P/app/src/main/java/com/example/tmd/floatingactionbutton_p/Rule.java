package com.example.tmd.floatingactionbutton_p;

import android.util.Log;

import java.util.Arrays;

public class Rule {
    public final int SL_NGUYEN_AM_MAX = 3;
    public final int SL_NGUYEN_AM_MIN = 1;
    public final int SL_PHU_AM_MAX = 5;
    public final int SL_PHU_AM_MIN = 0;
    public final static String[] phuAmCuoi = {"c", "ng", "nh", "ch", "m", "n", "p", "t", ""};
    public final static String[] notPhuAmCuoi = {"b", "d", "đ", "g", "h", "k", "l", "q",
            "r", "s", "v", "x", "gh", "gi", "kh", "ph", "q",
            "th", "tr", "ngh", "c", "ng", "nh", "ch", "m",
            "n", "p", "t", "gi", ""};
    public final static String[] nguyenAm = {
            "a", "à", "á", "ả", "ã", "ạ",
            "ai", "ài", "ái", "ải", "ãi", "ại",
            "ao", "ào", "áo", "ảo", "ão", "ạo",
            "au", "àu", "áu", "ảu", "ạu",
            "ay", "ày", "áy", "ảy", "ãy", "ạy",
            "ă", "ằ", "ắ", "ẳ", "ẵ", "ặ",
            "â", "ầ", "ấ", "ẩ", "ẫ", "ậ",
            "âu", "ầu", "ấu", "ẩu", "ẫu", "ậu",
            "ây", "ầy", "ấy", "ẩy", "ẫy", "ậy",
            "e", "è", "é", "ẻ", "ẽ", "ẹ",
            "eo", "èo", "éo", "ẻo", "ẽo", "ẹo",
            "ê", "ề", "ế", "ể", "ễ", "ệ",
            "êu", "ều", "ếu", "ểu", "ễu", "ệu",
            "i", "ì", "í", "ỉ", "ĩ", "ị",
            "ia", "ìa", "ía", "ỉa", "ĩa", "ịa", "ià", "iá", "iả", "iã", "iạ",
            "iê", "iề", "iế", "iể", "iễ", "iệ",
            "iu", "ìu", "íu", "ỉu", "ĩu", "ịu",
            "iêu", "iều", "iếu", "iểu", "iễu", "iệu",
            "o", "ò", "ó", "ỏ", "õ", "ọ",
            "oa", "oà", "oá", "oả", "oã", "oạ", "óa", "òa", "ỏa", "õa", "ọa",
            "oai", "oài", "oái", "oải", "oãi", "oại",
            "oay", "oày", "oáy", "oảy", "oãy", "oạy",
            "oă", "oằ", "oắ", "oẳ", "oẵ", "oặ",
            "oe", "òe", "óe", "ỏe", "õe", "ọe",
            "oi", "òi", "ói", "ỏi", "õi", "ọi",
            "oo", "oò", "oó",
            "ô", "ồ", "ố", "ổ", "ỗ", "ộ",
            "ôi", "ồi", "ối", "ổi", "ỗi", "ội",
            "ơ", "ờ", "ớ", "ở", "ỡ", "ợ",
            "ơi", "ời", "ới", "ởi", "ỡi", "ợi",
            "u", "ù", "ú", "ủ", "ũ", "ụ",
            "ua", "ùa", "úa", "ủa", "ũa", "ụa", "uà", "uá", "uả", "uã", "uạ",
            "uài", "uái", "uải", "uãi", "uại",
            "uay", "uày", "uáy", "uảy", "uãy", "uạy",
            "uâ", "uầ", "uấ", "uẩ", "uẫ", "uậ",
            "uây", "uầy", "uấy", "uẩy", "uẫy", "uậy",
            "ui", "ùi", "úi", "ủi", "ũi", "ụi",
            "uê", "uề", "uế", "uể", "uễ", "uệ",
            "uô", "uồ", "uố", "uổ", "uỗ", "uộ",
            "uôi", "uồi", "uối", "uổi", "uỗi", "uội",
            "uơ", "uớ", "uở",
            "uy", "ùy", "úy", "ủy", "ũy", "ụy",
            "uya",
            "uyê", "uyề", "uyế", "uyể", "uyễ", "uyệ",
            "uỷu",
            "ư", "ứ", "ừ", "ử", "ữ", "ự",
            "ưa", "ừa", "ứa", "ửa", "ữa", "ựa",
            "ưi", "ừi", "ứi",
            "ươ", "ườ", "ướ", "ưở", "ưỡ", "ượ",
            "ươi", "ười", "ưới", "ưởi", "ưỡi", "ượi",
            "ươu", "ườu", "ượu",
            "ưu", "ừu", "ứu", "ửu", "ữu", "ựu",
            "y", "ỳ", "ý", "ỷ", "ỹ", "ỵ",
            "yê", "yề", "yế", "yể", "yễ", "yệ",
            "yêu", "yều", "yểu"
    };
    public final static char[] nguyenAmDacBiet = {'e', 'è', 'é', 'ẻ', 'ẽ', 'ẹ', 'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ', 'i', 'ì', 'í', 'ỉ', 'ĩ', 'ị'};
    public final static String[] nguyenAmDauSacvaNang = {
            "á", "ạ", "ắ", "ặ", "ấ", "ậ",
            "é", "ẹ", "ế", "ệ",
            "í", "ị", "iế", "iệ",
            "ó", "ọ", "oá", "oạ", "oắ", "oặ",
            "óe", "ọe", "oó", "ố", "ộ",
            "ớ", "ợ",
            "ú", "ụ", "uấ", "uậ", "uế", "uệ", "uố", "uộ", "uớ",
            "uyế", "uyể", "uyễ", "uyệ",
            "ứ", "ự", "ướ", "ượ",
            "yế", "yệ"
    };

    public static boolean checkValid(Xau x) {
        if (checkDoDai(x) == false) return false;    //kiem tra do dai phai <=7
        if (checkCauTruc(x) == false) return false;    //kiem tra cau truc p-n-p hop ly khong
        if (checkPhuAmDacBiet(x) == false)
            return false;    //kiem tra nguyen am di kem voi gh,ngh va g,ng,c
        if (checkPhuAmQ(x) == false) return false;    //kiem tra sau q phai la u
        if (checkPhuAmK(x) == false)
            return false;    //kiem tra sau k phai la nguyen am dac biet hoac y
        if (checkNguyenAmDai(x) == false)
            return false;    //nguyen am dai 3 (trừ "uyê") hoac nguyen am dai 2 duoi i,o,u,y (trừ uy,oo) khong duoc co phu am cuoi
        if (checkNguyenAmNgan(x) == false) return false;    // nguyen am ă va â phai co phu am cuoi
        if (checkPhuAmNgat(x) == false)
            return false;    //kiem tra nguyen am khi phu am la c, ch, p, t
        return true;
    }

    public static boolean checkCauTruc(Xau x) {
        return x.tachXau();
    }

    public static boolean checkDoDai(Xau x) {
        if (x.xau.length() > 7) return false;
        return true;
    }

    public static boolean checkPhuAmDacBiet(Xau x) {
        if ((x.phu_am_dau.compareTo("gh") == 0) || (x.phu_am_dau.compareTo("ngh") == 0)) {
            char tmp = x.xau.charAt(x.phu_am_dau.length());
            return (x.isNguyenAmDacBiet(tmp));
        }
        if ((x.phu_am_dau.compareTo("g") == 0) || (x.phu_am_dau.compareTo("ng") == 0) || (x.phu_am_dau.compareTo("c") == 0)) {
            char tmp = x.xau.charAt(x.phu_am_dau.length());
            if (x.phu_am_dau.compareTo("g") == 0) { //rieng g co the dung truoc i
                if ((tmp == 'i') || (tmp == 'ì') || (tmp == 'ỉ')) return true;
            }
            return (!x.isNguyenAmDacBiet(tmp));
        }
        return true;
    }

    public static boolean checkPhuAmK(Xau x) {
        if (x.phu_am_dau.compareTo("k") == 0) {
            char tmp = x.xau.charAt(1);
            if ((x.isNguyenAmDacBiet(tmp) == false) && (tmp != 'y') && (tmp != 'ỳ') && (tmp != 'ý') && (tmp != 'ỷ') && (tmp != 'ỹ') && (tmp != 'ỵ'))
                return false;
        }
        return true;
    }

    public static boolean checkPhuAmQ(Xau x) {
        if (x.phu_am_dau.compareTo("q") == 0) {
            char tmp = x.xau.charAt(1);
            if ((tmp != 'u') && (tmp != 'ù') && (tmp != 'ú') && (tmp != 'ủ') && (tmp != 'ũ') && (tmp != 'ụ'))
                return false;
            if (x.xau.length() == 2) return false;
            if (x.isPhuAm(String.valueOf(x.xau.charAt(2))) == true) return false;
        }
        return true;
    }

    public static boolean checkNguyenAmDai(Xau x) {
        if (x.so_nguyen_am == 3) {
            if ((x.nguyen_am.compareTo("uyê") != 0) && (x.nguyen_am.compareTo("uyề") != 0) &&
                    (x.nguyen_am.compareTo("uyế") != 0) && (x.nguyen_am.compareTo("uyể") != 0) &&
                    (x.nguyen_am.compareTo("uyễ") != 0) && (x.nguyen_am.compareTo("uyệ") != 0)) {
                if (x.phu_am_cuoi.compareTo("") != 0) return false;
            }
        }
        if (x.so_nguyen_am == 2) {
            if ((x.nguyen_am.charAt(1) == 'i') || (x.nguyen_am.charAt(1) == 'o') || (x.nguyen_am.charAt(1) == 'y') || (x.nguyen_am.charAt(1) == 'u'))
                if ((x.nguyen_am.compareTo("uy") != 0) && (x.nguyen_am.compareTo("ùy") != 0) &&
                        (x.nguyen_am.compareTo("úy") != 0) && (x.nguyen_am.compareTo("ủy") != 0) &&
                        (x.nguyen_am.compareTo("ũy") != 0) && (x.nguyen_am.compareTo("ụy") != 0) && (x.nguyen_am.compareTo("oo") != 0))
                    if (x.phu_am_cuoi.compareTo("") != 0) return false;
        }
        return true;
    }

    public static boolean checkNguyenAmNgan(Xau x) {
        if (x.nguyen_am.length() == 1) {
            if ("ăắằẳẵặâấầẩẫậ".contains(x.nguyen_am) == true) {
                if (x.phu_am_cuoi.compareTo("") == 0) return false;
            }
        }
        return true;
    }

    public static boolean checkPhuAmNgat(Xau x) {
        if ((x.phu_am_cuoi.compareTo("c") == 0) || (x.phu_am_cuoi.compareTo("ch") == 0) || (x.phu_am_cuoi.compareTo("p") == 0) || (x.phu_am_cuoi.compareTo("t") == 0)) {
            for (int i = 0; i < nguyenAmDauSacvaNang.length; i++) {
                if (x.nguyen_am.compareTo(nguyenAmDauSacvaNang[i]) == 0) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final static String[] htmlTag = {

    };

    public static void main(String[] args) {
        Arrays.sort(Rule.nguyenAm);
        Arrays.sort(Rule.phuAmCuoi);
        Arrays.sort(Rule.notPhuAmCuoi);
        Arrays.sort(Rule.nguyenAmDacBiet);
        /*
        Xau key = new Xau("thanh"); //test 1 từ
		System.out.println(checkValid(key));
		*/

        String paragraph = "THIÊN NHAI TƯ QUÂN BẤT KHẢ VONG-<br/>    tay ắt nàng không sao chống đỡ được, trong lòng không khỏi hơi khiếp sợ. Vệ Thiên Vọng tay phải rút kiếm ra khỏi bao, tay trái hai ngón tay kẹp lấy mũi kiếm, vận sức vào đốt ngón tay, nghe cách một tiếng, đầu kiếm đã gãy làm hai, rồi bỏ cả hai mảnh trở lại bao, nói:<br/>-         Ai thèm lấy cái thứ kiếm vô dụng của ngươi làm gì!<br/>Quách Tương thấy kình lực ngón tay của y lợi hại như thế không khỏi hãi sợ. Vệ Thiên Vọng thấy nàng biến sắc, đắc ý ngửng đầu cười ha hả. Tiếng cười của y ù cả tai, rung động đến nỗi ngói trên mái đình cũng kêu lách cách.<br/>Trong khi tiếng vang chưa dứt, bỗng dưng mái đình thủng một mảng lớn, một vật gì đó rơi bịch xuống đất. Mọi người ai nấy giật mình, đến Vệ Thiên Vọng cũng không tưởng nổi y nội lực sung túc đến mức tiếng cười có thể làm chấn động mái ngói. Thực ra tiếng cười của y không hàm ý vui vẻ mà chỉ là vận kình kêu lên ha ha vài tiếng, vậy mà làm thủng được mái ngói, khiến y vừa mừng vừa sợ, không ngờ gần đây nội lực của mình lại tiến bộ đến thế. Thế nhưng nhìn lại cái vật vừa rơi xuống lại càng sợ hơn, chỉ thấy đó là một hán tử trung niên mặc áo trắng, hai tay ôm một cây dao cầm, lăn quay dưới đất, mắt vẫn nhắm nghiền ngủ say sưa.<br/>Quách Tương vui mừng nói:<br/>-         Ồ, ông cũng ở đây sao?<br/>Hóa ra người đàn ông này chính là người ngồi đánh đàn nàng gặp mấy hôm trước trên núi. Người đó nghe tiếng Quách Tương, vội nhỏm dậy, nói:<br/>-         Cô nương, tôi đang đi tìm cô, không ngờ lại gặp nhau ở đây.<br/>Quách Tương hỏi:<br/>-         Ông đi kiếm tôi có chuyện gì thế?<br/>Người đó đáp:<br/>-         Tôi quên không thỉnh giáo tôn tính đại danh của cô nương.<br/>Quách Tương nói:<br/>-         Cái gì mà tôn tính đại danh? Những lời màu mè giả dối đó tôi không thích chút nào.<br/>Người nọ khựng lại, cười đáp:<br/>-         Đúng lắm, đúng lắm. Càng để ý đến hư văn, loại người đó càng không có chân tài thực học. Hạng đó đi lòe mấy người nhà quê, chứ làm được chuyện gì.<br/>Y vừa nói vừa liếc nhìn Vệ Thiên Vọng, cười khẩy mấy tiếng. Quách Tương mừng lắm, không ngờ người này biết hết mọi chuyện, cố ý giúp đỡ mình. <br/>Vệ Thiên Vọng thấy người nọ liếc mình, mặt y đã xanh lại càng xanh thêm, lạnh lùng hỏi:<br/>-         Tôn giá là ai?<br/>Người nọ không thèm để ý tới y, nói với Quách Tương:<br/>-         Cô nương, tên cô là gì nhỉ?<br/>Quách Tương nói:<br/>-         Tôi họ Quách, đơn danh Tương.<br/>Người nọ vỗ tay:<br/>-         A, thật đúng là có mắt mà không thấy núi Thái Sơn, hóa ra đây là Quách đại cô nương, người mà bốn bể ai cũng nghe danh. Lệnh tôn là Quách Tĩnh Quách đại hiệp, lệnh đường Hoàng Dung Hoàng nữ hiệp, trừ bọn vô tri vô thức, không biết trời trăng gì mới không biết đến, chứ trên giang hồ có ai không hay, có ai không biết? Hai vị đó văn võ song toàn, đao thương kiếm kích, quyền chưởng khí công, cầm kỳ thư họa, thi từ ca phú, xưa nay không môn gì không hơn người, ai mà bì kịp. Ha ha, chỉ có cái bọn thong manh, mới không nghe đến tiếng vang vọng của hai ông bà.<br/>Quách Tương trong lòng thật vui, nghĩ thầm : Thì ra ngươi ẩn náu ở trên nóc đình, đã nghe thấy những gì ta nói với ba người này rồi. Xem ra chính ngươi cũng chẳng biết gì về cha mẹ ta. Ta thứ hai, vậy mà gọi là đại cô nương, lại bảo cha ta cũng thông cầm kỳ thư họa, thi từ ca phú, thật đáng nực cười.<br/>Nghĩ như thế nên nàng cười hỏi lại:<br/>-         Thế còn tên ông là gì?<br/>Người kia đáp:<br/>-         Tôi họ Hà, tên là Túc Đạo.<br/>Quách Tương cười:<br/>-         Hà Túc Đạo, Hà Túc Đạo ư? Cái tên ông sao khiêm tốn quá vậy.[7]<br/>Hà Túc Đạo nói:<br/>-         So với cái bọn thiên gì, địa gì khoác lác không biết xấu hổ, cái thứ nhãi nhép cuồng vọng tự tôn, thùng rỗng kêu to chỉ tổ làm người ta buồn mửa.<br/>Hà Túc Đạo liên tiếp mỉa mai châm chọc bọn ba anh em Vệ Thiên Vọng. Ba người thấy y ép sập nóc đình rơi xuống, hẳn không tầm thường, lúc đầu họ còn cố nhịn, để xem bạch y quái khách này là hạng người nào. Thế nhưng càng nghe lời lẽ y càng chua cay, Vệ Thiên Vọng thấy không còn chịu nổi, vung tay nhắm ngay má trái của y đánh ra một chưởng.<br/>Hà Túc Đạo hơi cúi đầu, luồn dưới cánh tay y mà lách qua. Vệ Thiên Vọng chỉ thấy cổ tay trái hơi tê, thanh kiếm trong tay y đã bị đoạt mất. Lúc Vệ Thiên Vọng đoạt kiếm của Quách Tương, thân pháp thật là nhanh, khiến người ta không sao nhìn rõ, nhưng lúc này Hà Túc Đạo lách qua nhẹ nhàng thuận tay lấy lại thanh đoản kiếm, từ thân pháp đến cử động, không có điểm nào khác thường.<br/>Vệ Thiên Vọng kinh hãi, tiến lên một bước, mấy ngón tay như cái móc, chộp luôn vào vai y. Hà Túc Đạo lại nghiêng người né tránh, trảo đó lướt qua thân y. Phan Thiên Canh và Phương Thiên Lao đột nhiên nhảy lùi lại ra ngoài đình. Vệ Thiên Vọng tả quyền hữu chưởng đánh ra, tiếng gió kêu vù vù, chỉ giây lát đã đánh ra bảy tám chiêu liền. Hà Túc Đạo né trái lách phải, khiến đến vạt áo cũng không chạm đến. Tay y cầm thanh đoản kiếm, đối với quyền chiêu gió táp mưa sa của đối phương không hề đỡ gạt, chỉ nhẹ nhàng nghiêng người đã làm cho Vệ Thiên Vọng đánh hụt ra ngoài.<br/>Đối với lứa tuổi của Quách Tương, tuy võ thuật nàng không tinh thâm nhưng trong những người quen biết không hiếm cao thủ vào hạng nhất, kiến thức lại hơn người, thấy Hà Túc Đạo cử động trông nhẹ nhàng nhưng thân pháp hết sức xảo diệu, né tránh những chiêu thức cực kỳ cương mãnh của địch, võ công thân pháp thành riêng một nhà, so với các môn phái ở Trung Thổ không giống ai, càng xem càng thấy kỳ lạ.<br/>Vệ Thiên Vọng liên tiếp đánh ra hơn hai chục chiêu vẫn không ép được đối phương xuất thủ, hự một tiếng nhỏ, quyền pháp bất ngờ đổi hẳn, xuất chiêu chậm chạp, nhưng quyền lực nặng nề. Quách Tương đứng ở bên trong đình, cảm thấy quyền phong càng lúc càng nặng đẩy nàng từng bước lùi ra bên ngoài.<br/>Lúc này Hà Túc Đạo không còn có thể chỉ né tránh mà không trả đòn, y cài đoản kiếm vào dây lưng, hai chân đứng vững lại, quát lên:<br/>-         Ngươi biết ngạnh công, tưởng ta không biết sao?<br/>Đợi Vệ Thiên Vọng hai chưởng đánh tới, tay trái phản kích lại một chưởng, lấy ngạnh công chống với ngạnh công, nghe bình một tiếng, Vệ Thiên Vọng thân hình hơi lảo đảo, lùi lại hai bước. Hà Túc Đạo đứng nguyên một chỗ không động đậy.<br/>Vệ Thiên Vọng vẫn tự cho là mình ngoại môn ngạnh công trên đời ít ai bì kịp, nào ngờ đối phương lấy cứng chống cứng không hề mượn sức hay trổ tài khéo léo, đẩy mình lùi lại. Y trong lòng không phục, hít một hơi, quát lên một tiếng, hai chưởng lại đánh ra. Hà Túc Đạo cũng quát lên một tiếng, đánh lại một chưởng. Chỉ nghe tiếng ầm ầm liên tiếp, khiến cho lỗ hổng trên mái đình đất đá rơi xuống rào rào.<br/>Vệ Thiên Vọng lùi lại bốn bước, sau cùng cũng đứng lại được. Y đỡ xong hai chưởng này, đầu tóc rồi bù, hai mắt lồi ra, hình dáng trông thật dễ sợ. Hai tay y ôm vào đan điền, thở hù hù vận khí mấy lần, ngực lõm vào, bụng lại phình ra như cái trống, toàn thân các khớp xương kêu lốp cốp, từng bước từng bước chậm chậm bước về phía Hà Túc Đạo.<br/>Hà Túc Đạo thấy tình thế của y như vậy, không dám coi thường, điều vận chân khí, đứng chờ thế của địch.<br/>Vệ Thiên Vọng đi đến còn cách đối phương chừng bốn năm thước, đã tưởng phát chiêu, nào ngờ không ngừng bước mà vẫn tiếp tục tiến thêm hai bước nữa, đến đứng đối diện tưởng như hơi thở của nhau có thể cảm thấy được, lúc ấy hai chưởng mới tung ra, một chưởng đánh vào mặt, một chưởng lại đánh vào bụng dưới. Lần này y phân ra hai chưởng, cốt để đối thủ phải phân lực ra làm hai. Chiêu thế cũng như chưởng lực đều thật là hùng mạnh.<br/>Hà Túc Đạo cũng lập tức hai chưởng đưa ra, hai tay chéo lại, tay trái y đỡ lấy tay trái địch thủ, tay phải y đỡ lấy tay phải của địch, nhưng chưởng lực lại phân thành một cương, một nhu. Vệ Thiên Vọng chỉ thấy chưởng của y đánh vào bụng dưới địch như đánh vào chỗ không, còn tay phải đánh vào mặt thì như đụng phải tường đồng vách sắt, biết là không ổn, chỉ thấy mình bị một lực to lớn đánh vào, khiến cả thân hình y bị đẩy văng ra khỏi thạch đình.<br/>Kỳ này hai người lấy cứng chọi cứng, dùng lực chống lực, ai yếu hơn sẽ bị thương, không thể nào lấy gì ngoắt ngoéo. Dù cho Vệ Thiên Vọng có gượng đứng được, hoặc một chiêu đã ngã, thì chưởng lực của chính y phản kích trở lại, lại thêm chưởng lực của Hà Túc Đạo, ắt y thể nào cũng phải hộc máu tươi. Phan Thiên Canh và Phương Thiên Lao cùng kêu lên:<br/>-         Ra tay!<br/>Hai người đồng thời nhảy tới, cùng chia nhau mỗi người nắm một cánh tay của Vệ Thiên Vọng nhắc lên, có thế mới tiêu trừ được chưởng lực cương mãnh của Hà Túc Đạo. Vệ Thiên Vọng tuy chưa bị thương, nhưng ruột gan đã chấn động, xương cốt toàn thân tưởng như nát nhừ, thở không ra hơi, không đứng nổi. Ông già lùn mặt đỏ Phương Thiên Lao thấy sư đệ bị một trận đau như thế, trong bụng vừa giận vừa sợ, nhưng mặt ngoài vẫn cười hì hì, nói:<br/>-         Các hạ chưởng lực mạnh như thế, quả thực trên đời ít thấy, bội phục bội phục.<br/>Quách Tương nghĩ thầm: Nói đến chưởng lực cương mãnh hùng hậu, ai bằng được Hàng Long Thập Bát Chưởng của cha ta? Bọn Côn Lôn Tam Thánh các ngươi trốn lánh ở chốn hoang sơn, ếch ngồi đáy giếng, tưởng là mình giỏi, rồi sẽ có ngày biết đến võ công Trung Thổ. Nàng nghĩ đến đây, trong lòng hơi se lại, vì lúc nàng muốn cho bọn Phương Thiên Lao biết đến võ công Trung Thổ, không phải là biết đến phụ thân mà chính là Dương Quá.<br/>Chỉ nghe Phương Thiên Lao nói tiếp:<br/>-         Tiểu lão nhi bất tài, xin ra lãnh giáo kiếm pháp của các hạ.<br/>Hà Túc Đạo nói:<br/>-         Phương huynh đối xử với Quách cô nương thật nể nang, tại hạ không trách gì cả, chúng ta tỉ thí làm gì.<br/>Quách Tương ngạc nhiên: Ngươi cho gã họ Vệ kia một phen khổ sở, nguyên lai chỉ vì y đối với ta không nể nang ư?<br/>Phương Thiên Lao đến bên con ngựa y cưỡi, từ bao vải lấy ra một thanh trường kiếm, nghe một tiếng soẹt, đã rút ra khỏi vỏ, giơ ngón tay búng vào thân kiếm một cái, tiếng u u nổi lên một hồi lâu không dứt. Khi kiếm đã trong tay, nụ cười trên môi lập tức biến mất, tay trái bắt kiếm quyết đưa ra trước mặt, ngón tay đưa lên, tay phải cầm kiếm chỉ lên trời không động đậy, chính là chiêu Tiên Nhân Chỉ Lộ.<br/>Hà Túc Đạo nói:<br/>-         Nếu quả Phương huynh muốn động thủ, thì tôi xin dùng đoản kiếm của Quách cô nương thử một vài chiêu.<br/>Y nói rồi rút ra nửa thanh kiếm gãy. Thanh kiếm đó vốn đã dài không quá hai thước, sau khi Vệ Thiên Vọng dùng ngón tay bẻ gãy rồi, lưỡi kiếm chỉ còn bảy tám tấc. Đầu kiếm lại thẳng không nhọn, đến như con dao găm cũng không bằng. Tay trái y cầm bao kiếm, tay phải cầm thanh kiếm gãy nhảy vào tấn công.<br/>Lần nay y ra tay cực kỳ nhanh nhẹn, trước mắt Phương Thiên Lao chỉ thấy một vệt trắng thấp thoáng, Hà Túc Đạo đã liên tiếp công kích ba chiêu, tuy rằng thanh kiếm gãy quá ngắn không làm y bị thương, nhưng Phương Thiên Lao trong bụng cũng hãi sợ, nghĩ thầm: Ba chiêu này nhanh thật, quả không dễ gì né tránh, kiếm pháp này là kiếm pháp gì đây? Nếu trong tay y mà là trường kiếm thì có lẽ máu mình đã đổ ra tại chỗ rồi.<br/>Hà Túc Đạo tấn công ba chiêu xong, lui ra một bên, đứng yên bất động. Phương Thiên Lao khai triển kiếm pháp, nửa thủ nửa công, hung hăng xông tới. Hà Túc Đạo né qua một bên, nhưng không trả đòn, lại bất ngờ tấn công ba chiêu thật nhanh, ép Phương Thiên Lao phải tay chân lúng túng, rồi lại nhảy ra ngoài đứng chờ. Thanh kiếm trong tay Phương Thiên Lao lại tung ra tấn công, chỉ thấy ánh sáng trắng nhấp nháy, cực kỳ nhanh nhẹn.<br/>Quách Tương nghĩ thầm: Lão già này chiêu số thật là cương mãnh, độc địa, so với chưởng pháp của lão họ Vệ cũng cùng một lối, có điều có thêm ba phần linh động, lại có vẻ lợi hại hơn ... Vừa nghĩ tới đây, chợt nghe Hà Túc Đạo quát lên: Cẩn thận nhé. Chữ nhé vừa ra khỏi miệng, bao kiếm bên tay trái giơ lên, nhanh như điện chớp, nghe xẹt một tiếng nhỏ, bao kiếm trong tay đã chụp lấy mũi kiếm của Phương Thiên Lao, kiếm bên tay phải nhanh nhẹn chĩa ngay vào yết hầu địch thủ.<br/>Trường kiếm của Phương Thiên Lao không còn tự do, không cách gì có thể thu kiếm về để gạt, mắt thấy kiếm đâm vào cổ họng mình, chỉ còn cách bỏ thanh kiếm, lăn ngay xuống đất, mới tránh được chiêu này. Y chưa kịp đứng dậy, một bóng người thấp thoáng, Phan Thiên Canh đã vọt mình nhảy tới, chộp lấy chuôi thanh trường kiếm, xoay mình một cái, rút ra khỏi bao. Cả Hà Túc Đạo lẫn Quách Tương đều lên tiếng khen ngợi:<br/>-         Hảo thân pháp!<br/>Ông già mặt trông như người bệnh ấy trước sau không thốt ra một lời, võ công hóa ra cao nhất trong ba người. Hà Túc Đạo nói:<br/>-         Công phu của các hạ cao cường, tại hạ thật bội phục.<br/>Nói rồi quay đầu lại nói với Quách Tương:<br/>-         Quách cô nương, từ khi được nghe nhã tấu của cô nương hôm trước, tôi đã sáng tác một bản đàn, mong được cô nương bình phẩm.<br/>Quách Tương nói:<br/>-         Bản đàn nào thế?<br/>Hà Túc Đạo ngồi xuống xếp bằng, lấy cây dao cầm đặt lên lòng, lên dây thử vận, rồi bắt đầu gẩy đàn.<br/>Phan Thiên Canh nói:<br/>-         Các hạ liên tiếp đánh bại hai người sư đệ của tôi, họ Phan này muốn được thỉnh giáo.<br/>Hà Túc Đạo xua tay:<br/>-         Chuyện tỉ thí võ công đã qua rồi, không còn hứng thú gì nữa. Đây là một bản đàn mới, ta đang muốn gẩy cho Quách cô nương nghe. Ba vị nếu như muốn nghe, xin mời ngồi xuống, nếu như không hiểu, xin cứ tự tiện.<br/>Tay trái ấn phím, tay phải bắt đầu đánh đàn. Quách Tương chỉ mới nghe vài nốt, bất giác vừa mừng vừa sợ. Hóa ra bản đàn này một phần là từ Khảo Bàn là khúc nàng đã tấu qua, nhưng một phần khác lại từ trong thơ Kiêm Gia, hai bản không cùng một điệu, nhưng y đã hòa lại với nhau, một ứng một đáp, nghe ra thật là kỳ diệu. Tuy nhiên khi nghe cầm vận tới đoạn khảo bàn tại giản, thạc nhân chi khoan. Kiêm gia thương thương, bạch lộ vi sương, sở vị y nhân, tại thiên nhất phương ... thạc nhân chi khoan, thạc nhân chi khoan ... tố hồi tòng chi, đạo trở thả trường, tố du tòng chi, uyển tại thủy trung ương ... độc tẩm ngụ ngôn, vĩnh thỉ vật huyên, vĩnh thỉ vật huyên ... Quách Tương trong lòng thấy hơi chạnh lòng: Trong tiếng đàn của y có nói đến y nhân, chẳng lẽ nhắc đến ta ư? Sao điệu đàn có vẻ ý tứ triền miên đến thế, nghe đầy những nhớ thương cảm mến? Nghĩ đến đây, nàng không khỏi ửng hồng đôi má. Có điều điệu đàn đó biến chuyển thực là khéo léo, nguyên vận hai bài Khảo Bàn và Kiêm Gia không lạc nhau chút nào, hai bên nhịp nhàng đối đáp, song vẫn giữ được tất cả những hoa mỹ của cả hai. Trong đời nàng chưa bao giờ được nghe một khúc nhạc như thế cả.<br/>Thế nhưng bọn Phan Thiên Canh ba người chẳng ai hiểu gì. Họ không biết rằng Hà Túc Đạo là người hơi điên khùng, có chút mê mẩn của một cuồng sĩ, vừa làm được một bản đàn, nhất định phải kiếm Quách Tương để gẩy cho nghe bằng được, huống chi khúc đàn này cũng vì nàng mà sáng tác, nên lúc ấy mọi việc đều gác sang một bên. Thế nhưng ba ông già thấy y ngưng thần đánh đàn, chẳng thèm để ý chi đến mình, quả thực hết sức khinh người, làm sao họ có thể nhịn nổi? Phan Thiên Canh vung thanh trường kiếm, điểm ngay vào vai bên trái Hà Túc Đạo, hét lớn:<br/>-         Mau đứng lên, ta với ngươi hai người so tài nào!<br/>Hà Túc Đạo toàn thể tâm trí đang để vào tiếng đàn, tưởng mình đang là một thư sinh ngao du nơi khe núi, ngắm một thiếu nữ ôn nhu đứng trên một hòn đảo nhỏ xa xa, lòng không ngại núi non cách trở, đang cố tìm cách qua gặp nàng ...<br/>Bỗng dưng thấy vai trái nhói một cái, y liền tỉnh mộng, quay đầu nhìn lại, thấy trường kiếm trong tay Phan Thiên Canh đã chỉ vào đầu vai mình, đâm nhẹ vào da, nếu không đỡ gạt, e rằng đối phương sẽ tiện đà đâm tới khiến cho bị thương. Thế nhưng bản đàn chưa tấu xong, tục nhân lại ở bên cạnh quấy nhiễu, thực là phá đám. Y lập tức cầm thanh kiếm gãy, keng một tiếng, gạt thanh trường kiếm của Phan Thiên Canh ra, tay phải vẫn tiếp tục gảy đàn.<br/>Lúc này Hà Túc Đạo mới giở tuyệt kỹ bình sinh, tay phải đàn cầm, tay trái sử kiếm. Y không sao nhấn phím được nên nhắm năm dây đàn dùng sức thổi một cái, dây đàn lập tức lõm xuống, tay phải tiếp tục gảy như thường, tiếng đàn cao thấp trầm bổng, vẫn uyển chuyển như ý.<br/>Phan Thiên Canh cấp tốc công kích mấy chiêu, Hà Túc Đạo thuận tay gạt ra, hai mắt vẫn chăm chú nhìn dây đàn, chỉ e hơi thổi ra không trúng tiết, làm loạn tiếng đàn. Phan Thiên Canh càng thêm giận dữ, kiếm chiêu càng công càng nhanh, nhưng bất luận kiếm của y từ phương nào đâm tới, đều bị Hà Túc Đạo nhẹ nhàng gạt qua một bên.<br/>Quách Tương nghe tiếng đàn, trong lòng nổi nhạc hứng, không để ý gì đến những đường kiếm đánh tới của Phan Thiên Canh, thế nhưng hai thanh kiếm chạm nhau làm cho cầm thanh bị loạn. Hai tay nàng đánh nhịp theo tiếng đàn, nhíu mày nhìn Phan Thiên Canh nói:<br/>-         Ông ra chiêu lúc nhanh lúc chậm không hợp với tiếng đàn, bộ ông không biết gì về âm nhạc ư? Hừ, ông phải nghe theo tiếng đàn mà xuất kiếm, có theo nhịp thì nghe mới được.<br/>Phan Thiên Canh đời nào để ý đến cô, chỉ thấy trước mặt kẻ địch ngồi xếp bằng trên đất, tay chỉ cầm một thanh kiếm gãy, mắt chăm chú nhìn dây đàn, vậy mà mình không sao chạm được vào y, lại càng nóng ruột. Đột nhiên y đổi kiếm pháp, công kích càng nhanh hơn, hai món binh khí chạm nhau leng keng như tiếng mưa rào. Âm thanh cấp bách đó so với tiếng đàn ôn nhã triền miên quả thực không hài hòa chút nào.<br/>Hà Túc Đạo nhướng đôi lông mày, truyền kình lực vào thanh đoản kiếm, nghe cách một tiếng, thanh kiếm trong tay Phan Thiên Canh lập tức gãy ra làm đôi. Thế nhưng cũng lúc đó, dây thứ năm trong bảy dây đàn cũng đứt theo. Phan Thiên Canh mặt xám như tro, không nói một lời, chuyển thân chạy ra khỏi đình. Ba người nhảy lên lưng ngựa, chạy vọt lên hướng triền núi.<br/>Quách Tương thật lạ lùng, nói:<br/>-         Hừ, ba người này đánh đã thua rồi, tại sao còn chạy lên chùa Thiếu Lâm? Bộ họ muốn chết hay sao chứ?<br/>Nàng quay đầu lại, thấy Hà Túc Đạo mặt buồn thiu, tay vuốt ve dây đàn, tưởng như không nói lên được nỗi đau khổ của mình. Quách Tương nghĩ thầm: Một sợi dây đàn, có đáng gì đâu?.Lập tức tiếp lấy cây dao cầm cởi đoạn dây đàn bị đứt mở dây đàn ra căng lại sợi dây mới.<br/>Hà Túc Đạo lắc đầu thở dài, nói:<br/>Uổng phí bao năm tu tập, cuối cùng rồi lòng vẫn chưa tĩnh được. Tuy tay trái tôi đưa kình lực ra làm gãy được kiếm của y, nhưng tay phải cũng lại làm đứt dây đàn.<br/>Bấy giờ Quách Tương mới rõ, nguyên là y thất vọng vì võ công của mình luyện chưa thuần thục, nên cười đáp:<br/>-         Việc ông có thể tay trái dũng mãnh công địch , tay phải lại thư thả chậm rãi gẩy đàn, là phép phân tâm nhị dụng, trên cõi đời này hiện nay chỉ có ba người làm được thôi. Ông luyện chưa đến mức đó, cũng không có gì phải bực mình.<br/>Hà Túc Đạo hỏi lại:<br/>-         Ba người đó là ai?<br/>Quách Tương đáp:<br/>-         Vị thứ nhất là Lão Ngoan Đồng Chu Bá Thông, người thứ hai là cha tôi, còn người thứ ba là Dương phu nhân Tiểu Long Nữ. Trừ ba người ấy ra, dù cho là ông ngoại tôi Đào hoa đảo chủ, hay mẹ tôi, hoặc Thần Điêu đại hiệp Dương Quá, là những người võ công rất cao, nhưng cũng không làm được.<br/>Hà Túc Đạo nói:<br/>-         Thế gian có những kỳ nhân như thế, bao giờ có dịp mong cô đưa tôi đến gặp họ.<br/>Quách Tương buồn bã nói:<br/>-         Muốn gặp cha tôi thì không khó, còn hai vị kia, không biết đi đâu để kiếm họ được.<br/>Nàng thấy Hà Túc Đạo ngơ ngẩn xuất thần, lại nghĩ đến chuyện đứt dây đàn, nên an ủi y:<br/>-         Ông chỉ giơ tay đã đánh bại được Côn Lôn Tam Thánh, cũng đủ hãnh diện với đương thế rồi, hà tất vì chuyện nhỏ mọn là đứt dây đàn mà rầu rĩ không vui?<br/>Hà Túc Đạo giật mình kinh hãi, hỏi lại:<br/>-         Côn Lôn Tam Thánh ư? Cô nói gì? Sao cô lại biết?<br/>Quách Tương cười đáp:<br/>-         Ba lão già đó từ Tây Vực đến, ắt là Côn Lôn Tam Thánh đó. Bọn họ võ công quả nhiên có chỗ độc đáo, chỉ có điều khiêu chiến với chùa Thiếu Lâm, e rằng không tự lượng sức mình ...<br/>Nàng thấy sự kinh hoàng của Hà Túc Đạo mỗi lúc một nhiều, nên không dám nói tiếp nữa, hỏi lại:<br/>-         Có gì kỳ quái?<br/>Hà Túc Đạo lẩm bẩm:<br/>-         Côn Lôn Tam Thánh, Côn Lôn Tam Thánh Hà Túc Đạo chính là tôi đây.<br/>Quách Tương giật mình kinh hãi, nói:<br/>-         Ông là Côn Lôn Tam Thánh ư? Vậy còn hai người kia đâu?<br/>Hà Túc Đạo nói:<br/>-         Côn Lôn Tam Thánh chỉ có một người, xưa nay không phải ba người bao giờ. Tôi ở Tây Vực cũng có được một chút danh nho nhỏ, bạn bè ở đó nói tôi có ba tuyệt kỹ, cầm kỳ kiếm, có thể nói là cầm thánh, kỳ thánh, kiếm thánh. Nhân vì tôi sinh trưởng trong núi Côn Lôn, nên gán cho tôi một cái ngoại hiệu, gọi là Côn Lôn Tam Thánh. Thế nhưng tôi nghĩ cái chữ thánh đó, đâu phải dễ dàng gì mà xưng như thế? Thế nhưng người khác đã dát vàng lên trên mặt mình rồi, không thể từ chối được. Thành thử, tôi phải đổi tên, gọi mình là Túc Đạo, nối liền với nhau, thành là Côn Lôn Tam Thánh Hà Túc Đạo[8] để cho người khác nghe được không cho là tôi cuồng vọng tự đại.<br/>Quách Tương vỗ tay cười:<br/>-         Hóa ra là như thế. Tôi vẫn tưởng là Côn Lôn Tam Thánh phải là ba người. Thế ba ông già đó là ai?<br/>Hà Túc Đạo nói:<br/>-         Bọn họ ư? Họ thuộc phái Thiếu Lâm.<br/>Quách Tương lấy làm lạ, nói:<br/>-         Nguyên lai ba người này thuộc phái Thiếu Lâm. Ừ, võ công của họ quả đúng là cương mãnh. Không sai, ông già mặt đỏ sử dụng chính là Đạt Ma kiếm pháp. Đúng rồi, ông già bệnh hoạn mặt vàng lúc sau công kích thật gấp, chẳng phải Vi Đà Phục Ma kiếm hay sao? Chỉ vì họ thêm thắt biến hóa nhiều, nhất thời tôi không nhận ra được. Nhưng sao họ lại từ Tây Vực đến đây?<br/>Hà Túc Đạo nói:<br/>-         Chuyện này nói ra cũng có nguyên nhân. Mùa xuân năm ngoái, tôi ở tại đỉnh Kinh Thần Phong gẩy đàn, bỗng đâu nghe ngoài lều tranh có tiếng đấm đá, vội ra xem, thấy hai người đang vật nhau, cả hai đều đã trọng thương, nhưng vẫn tận lực chiến đấu. Tôi quát họ bắt ngừng tay, nhưng không ai chịu yên, tôi phải đến can hai người ra. Một trong hai người chỉ trợn ngược mắt lên rồi chết, người kia còn thoi thóp. Tôi đưa y vào trong lều, cho y uống một viên Thiếu Dương đơn, cứu chữa nửa ngày, nhưng vì bị thương quá nặng, linh đơn không cứu mạng nổi. Khi y sắp chết, nói tên là Doãn Khắc Tây ...<br/>Quách Tương A lên một tiếng, nói:<br/>-         Phải chăng người đánh nhau với y là Tiêu Tương Tử? Người đó thân hình cao gầy, mặt trông như xác chết, phải không?<br/>Hà Túc Đạo lạ lùng:<br/>-         Đúng vậy, sao cô cái gì cũng biết?<br/>Quách Tương đáp:<br/>-         Tôi đã gặp họ rồi, không ngờ hai tên thân thiết như thế, cuối cùng lại đánh nhau đến chết.<br/>Hà Túc Đạo nói:<br/>-         Doãn Khắc Tây nói rằng y một đời làm nhiều điều tàn ác, đến khi sắp chết, hối hận cũng đã muộn. Y nói y và Tiêu Tương Tử hai người vào chùa Thiếu Lâm ăn cắp một bộ kinh thư, nhưng người nọ e dè người kia, không ai dám để người kia coi trước, sợ nếu đối phương võ công cao hơn, sẽ ra tay trừ khử mình, chiếm lấy bộ kinh. Hai người ăn cùng mâm, ngủ cùng giường, một bước không rời nhau. Thế nhưng ăn thì sợ người kia hạ độc, ngủ thì sợ người kia ám toán, lúc nào cũng nơm nớp không an, lại sợ hòa thượng chùa Thiếu Lâm đuổi theo, nên phải chạy đến Tây Vực. Đến khi họ đến được Kinh Thần Phong, hai người đã gân cốt rã rời, nhưng không ai chịu ai, cuối cùng ra tay đánh nhau. Doãn Khắc Tây nói là Tiêu Tương Tử vốn võ công cao hơn y, lại ra tay đánh y trước một chưởng, nhưng kết quả y vẫn chiếm thượng phong. Sau y mới nghĩ ra rằng, Tiêu Tương Tử khi ở trên núi Hoa Sơn đã bị trọng thương, nguyên khí vẫn chưa hồi phục. Nói trắng ra, nếu hai người không e ngại lẫn nhau, chắc cũng không thể nào lên tới núi Côn Lôn được.<br/>Quách Tương nghe câu chuyện, nghĩ đến hai người đường đi lúc nào cũng lo ngay ngáy, đến chết cũng vẫn còn chưa yên bụng, không khỏi thương cảm, nên than:<br/>-         Chỉ vì một bộ kinh thư, đến nỗi sinh ra cớ sự.<br/>Hà Túc Đạo nói:<br/>-         Tên Doãn Khắc Tây nói xong câu chuyện, hơi đã đứt đoạn, sau cùng cầu tôi đến chùa Thiếu Lâm, nói lại với một vị tên hòa thượng tên là Giác Viễn, rằng kinh thư ở trong dầu chi đó. Tôi nghe thấy kỳ quái, cái gì mà lại kinh thư ở trong dầu? Định sẽ hỏi lại cho kỹ, nhưng nào ngờ y không còn chịu nổi, đã hôn mê bất tỉnh rồi. Tôi đợi y tỉnh lại sẽ hỏi cho ra lẽ, nào ngờ y thiếp đi rồi không tỉnh nữa. Tôi nghĩ hay là bộ kinh đó bao trong tấm vải tẩm dầu chăng? Thế nhưng tra xét khắp người hai tên này, không thấy gì cả. Nhận lời ủy thác của người, phải làm tròn việc. Tôi bình sinh chưa đặt bước đến Trung Thổ, cũng muốn nhân dịp này du ngoạn một phen, vì thế đến chùa Thiếu Lâm là vậy.<br/>Quách Tương hỏi lại:<br/>-         Thế sao ông lại đến chùa Thiếu Lâm hạ chiến thư, muốn cùng bọn họ tỉ thí võ nghệ?<br/>Hà Túc Đạo mỉm cười:<br/>-         Chuyện đó cũng là từ ba gã này mà ra. Ba người này là đệ tử tục gia của phái Thiếu Lâm Tây Vực. Cứ theo người trong võ lâm Tây Vực nói, họ đều là trong hàng chữ Thiên, cùng hàng với phương trượng chùa Thiếu Lâm Thiên Minh thiền sư. Hình như sư tổ của họ trước đây có chuyện bất đồng với sư huynh đệ, giận dữ bỏ đi, truyền ra một phái Tây Vực Thiếu Lâm. Nguyên võ công của phái Thiếu Lâm, tổ sư Đạt Ma truyền từ Thiên Trúc sang Trung Thổ, nay từ Trung Thổ lại truyền sang Tây Vực, cũng không có gì là lạ. Ba người đó nghe danh hiệu tôi là Côn Lôn Tam Thánh nên muốn đến so tài cao thấp. Họ tự hào là võ Thiếu Lâm thiên hạ vô địch, tôi muốn xưng cầm thánh, kỳ thánh thì cũng không sao. Còn cái danh hiệu kiếm thánh thì nhất định không chịu, không bỏ đi không được, chỉ được xưng là nhị thánh chứ không thể xưng là tam thánh. Chính lúc đó tôi lại đang sắp sửa ra đi, thành ra một công đôi chuyện, nên sai người đến ước hẹn sẽ gặp nhau tại chùa Thiếu Lâm, rồi tự mình lên đường đến Trung Nguyên. Nào hay ba vị nhân huynh này cước trình cũng thật mau lẹ, đã bôn ba đến nơi rồi.<br/>Quách Tương cười nói:<br/>-         Hóa ra sự việc là như thế, làm cho tôi chẳng hiểu đầu đuôi gì cả. Ba lão già giờ này chắc đã đến chùa Thiếu Lâm, không biết nói năng làm sao đây?<br/>Hà Túc Đạo nói:<br/>-         Tôi vốn dĩ không quen biết gì với các nhà sư chùa Thiếu Lâm, cũng không thù không oán, sở dĩ đính ước với họ mười ngày cốt đợi ba lão này tới, lúc đó mới động thủ. Hiện tại hai bên đã thử tài nhau rồi, thôi cả hai người mình cùng lên, đợi tôi truyền lại câu nói đó xong, rồi mình xuống núi.<br/>Quách Tương nhíu mày:<br/>-         Qui củ của mấy hòa thượng này rất chặt chẽ, không cho đàn bà con gái vào chùa.<br/>Hà Túc Đạo nói:<br/>-         Hừ, cái qui củ gì thối tha thế? Bọn mình cứ tiến vào, chẳng lẽ họ sẽ giết mình sao?<br/>Quách Tương tuy là một cô gái hiếu sự, nhưng từ khi làm quen với Vô Sắc thiền sư, nàng không còn địch ý với chùa Thiếu Lâm, nên cười lắc đầu:<br/>-         Tôi đứng ngoài sơn môn chờ, ông tự mình đi vào chùa truyền ngôn, như thế khỏi thêm phiền.<br/>Hà Túc Đạo gật đầu:<br/>-         Thế cũng được, cái bản đàn tôi chưa tấu xong, khi trở xuống tôi sẽ đàn lại cho cô nghe một lượt.<br/>--------------------------------------------------------------------------------<br/>[1] Đoạn này không biết trích từ kinh nào nên không rõ nghĩa. Độc giả nào biết xin chỉ giáo. Đa tạ<br/>[2] Chó dữ chặn đường<br/>[3] Nguyên tiếng Phạn Lanka là tên đảo Tích Lan (Sri Lanka), cũng là tên một ngọn núi ở đây. Tích Lan là nơi mà kinh điển nhà Phật được viết trên lá cây đầu tiên. Kinh Lăng Già tức là Lankavatara sutra.<br/>[4] Đàn có khảm ngọc<br/>[5] Vỗ bàn nơi suối nước là cái khoan khoái của người quân tử. Tỉnh hay mê cũng một mình mình biết, không bao giờ quên.<br/>[6] Vỗ bàn nơi gò cao là cái cốt cách của người quân tử. Dẫu tỉnh hay mê cũng chỉ mình biết không cần ai hay.<br/>[7] Hà Túc Đạo theo nghĩa đen là nói tới làm gì.<br/>[8] Có nghĩa không đáng gọi là Côn Lôn Tam Thánh.<br/>";
        int i = 0, j = 0;
        System.out.println(paragraph);
        for (i = 0; i < paragraph.length(); i++) {
            if ((i != 0) && (paragraph.charAt(i) == ' ')) {
                String stringKey = paragraph.substring(j, i);
                if (stringKey.trim().equals("")) {
//                    System.out.println("Xau Rong");
                    continue;
                }
                Xau key = new Xau(paragraph.substring(j, i));
                boolean result = checkValid(key);
                if (result == false) {
                    System.out.println(result);
                    System.out.println(key.getXau());
                }
                j = i;
            }
        }
        Xau key = new Xau(paragraph.substring(j, paragraph.length()));
        System.out.println(checkValid(key));

    }
}

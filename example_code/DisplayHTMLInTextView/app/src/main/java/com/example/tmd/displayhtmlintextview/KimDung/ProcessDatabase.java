package com.example.tmd.displayhtmlintextview.KimDung;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmd on 23/04/2017.
 */

public class ProcessDatabase {
    public static String content = "THIÊN NHAI TƯ QUÂN BẤT KHẢ VONG-<br/>\t\t\t\t\t\t   Quách Tương lấy làm lạ, hỏi:<br/>-         Ai lại để trên tay tượng Phật như thế nhỉ?<br/>Vô Sắc lắc đầu:<br/>-         Cũng không biết nữa. Trong mấy trăm tăng chúng chùa Thiếu Lâm chúng tôi, nếu như có ai lẻn vào, chẳng lẽ không thấy? La Hán Đường lúc nào cũng có tám đệ tử ngày đêm luân phiên canh gác. Khi có người trông thấy tờ giấy này lập tức phi báo lão phương trượng, ai ai cũng lấy làm lạ, nên mới triệu lão về chùa thương nghị.<br/>Quách Tương nghe đến đây, đã hiểu ý, nên nói:<br/>-         Phải chăng ông nghi tôi thông đồng với Côn Lôn Tam Thánh ở bên ngoài gây rối, để cho ba gã kia lẻn vào La Hán Đường để tờ giấy này, phải thế không?<br/>Vô Sắc nói:<br/>-         Tôi đã gặp cô rồi quyết không thể nào nghi cho cô được. Thế nhưng việc cũng trùng hợp lạ kỳ, cô nương vừa rời chùa, thì tờ giấy này lại xuất hiện tại La Hán Đường, thành thử phương trượng và Vô Tướng sư đệ không khỏi không nghi.<br/>Quách Tương nói:<br/>-         Tôi không biết ba gã này là ai. Đại hòa thượng, ông việc gì phải sợ? Mười ngày nữa, nếu như họ có gan đến đây, thì cứ xem hai bên cao thấp thế nào.<br/>Vô Sắc nói:<br/>-         Sợ thì có gì đâu mà sợ. Nếu như cô nương với họ không có liên quan gì, tôi không có gì phải áy náy cả.<br/>Quách Tương thấy ông ta quả có lòng tốt, chỉ ngại Côn Lôn Tam Thánh là chỗ quen biết với mình, khi động thủ ắt có nhiều điều cấm kỵ, ngại rằng sẽ đắc tội với bạn bè, nên nói:<br/>-         Nếu như họ thực lòng đến tìm hiểu võ nghệ, thì không nói làm gì. Còn không, cứ việc cho họ một phen khốn khổ. Cứ theo tờ giấy này khẩu khí xem ra cuồng vọng lắm. Cái gì mà \"một phen lãnh giáo\" là sao?<br/>Nàng nói tới đây, chợt nghĩ ra một việc nên tiếp:<br/>-         Hay là có ai trong chùa cấu kết, lén bỏ vào tờ giấy này chăng? Nếu thế cũng không lấy gì làm lạ.<br/>Vô Sắc nói:<br/>-         Chuyện đó chúng tôi cũng đã nghĩ tới rồi, nhưng nhất định không thể có. Tay của Hàng Long La Hán cao đến hơn ba trượng, ngày thường muốn phủi bụi trên pho tượng này, cũng phải bắc giá cao. Nếu có kẻ nào nhảy lên tới đó, khinh công giỏi như thế không phải là nhiều. Nếu như trong chùa có phản đồ thì tài nghệ cũng không đạt tới mức đó.<br/>Lòng hiếu kỳ của Quách Tương nổi lên, rất muốn xem thử ba gã Côn Lôn Tam Thánh xem họ là hạng người nào, tăng chúng chùa Thiếu Lâm cùng họ tỉ thí võ nghệ, kết quả ai thắng ai bại, ngặt là chùa Thiếu Lâm không tiếp nữ khách, xem ra cái trò vui này không cách nào coi tận mắt được.<br/>Vô Sắc thấy cô cúi đầu suy nghĩ, lại tưởng cô đang trù liệu kế sách hộ cho chùa Thiếu Lâm, nên nói:<br/>-         Chùa Thiếu Lâm cả nghìn năm qua đã chịu không biết bao nhiêu sóng to gió cả, còn tồn tại đến hôm nay. Nếu bọn Côn Lôn Tam Thánh kia nhất định cùng chúng tôi qua lại một phen, chùa Thiếu Lâm thể nào cũng cùng với họ chu toàn. Quách cô nương, nửa tháng nữa, cô ở trên chốn giang hồ sẽ nghe tin tức, để xem Côn Lôn Tam Thánh có lật đổ được chùa Thiếu Lâm không?<br/>Nói tới đây, hào khí của ông lại nổi lên bừng bừng như thời trai trẻ. Quách Tương cười đáp:<br/>-         Đại hòa thượng bỗng dưng nổi giận, ông nói năng như thế sao còn gọi là đệ tử nhà Phật được nữa? Tốt lắm, tôi mong nửa tháng nữa sẽ nghe được tin vui.<br/>Nói xong nàng quay mình nhảy lên lưng lừa. Hai người nhìn nhau cùng cười. Quách Tương giục con lừa đi lững thững xuống chân núi, trong lòng đã định bụng không thể nào không lên xem trận đấu. <br/>";
    public static List splitChapter(){
        List<String> mListParagraph = new ArrayList<String>();
        String[] arr = content.split("<br/>");
        for (int i = 0; i < arr.length; i++) {
            mListParagraph.add(arr[i]);
        }
        return mListParagraph;
    }
}

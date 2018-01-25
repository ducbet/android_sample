package com.kimdung.kimdungtronbo.models;

import android.util.Log;

import com.kimdung.kimdungtronbo.Rule.Xau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.text.Html.FROM_HTML_MODE_COMPACT;
import static com.kimdung.kimdungtronbo.Rule.Rule.checkValidToken;

/**
 * Created by tmd on 02/05/2017.
 */

public class Paragraph implements Serializable {
    private String mContent;
    private static final String TAG = "MY_TAG_Paragraph";
    private List<String> mListMisTake = new ArrayList<>();

    public void clearContentParagraphs() {
        mContent = null;
    }

    public List<String> checkValid() {
        // trả lại array các lỗi
        // thuật toán này loại bỏ các từ trùng lặp rồi mới kiểm tra
        // => đoạn văn độ dài càng lớn càng hiệu quả
        // nếu chia thành từng paragraph ntn thì cũng không hiệu quả lắm, thậm chi còn chậm hơn,
        // có thời gian sẽ sửa lại thuật toán cũ (để nguyên split và chạy lần lượt)

        // array chứa các lỗi sai
        ArrayList<String> listMistake = new ArrayList<>();

        // xóa toàn bộ html tag trong mContent
        String mTmpContent = removeHtmlTag();

        // xóa toàn bộ ký tự đặc biệt trong mContent
        mTmpContent = mTmpContent.replaceAll("\\W", " ");

        // cắt mContent thành từng token
        String[] stringAllToken;
        stringAllToken = mTmpContent.split(" ");

        List<String> arrayAllToken = new ArrayList<>(Arrays.asList(stringAllToken));

        for (int i = 0; i < arrayAllToken.size(); i++) {
            if (arrayAllToken.get(i).compareTo("") != 0) {
                String tmp = arrayAllToken.get(i).trim();// trim là thừa thì phải :/ để cho chắc
                // sau khi trim thì có thể tmp thành ""
                if (tmp.length() != 0) {
                    Xau key = new Xau(tmp);
                    boolean result = checkValidToken(key);
                    if (result == false) {
//                        Log.d(TAG, "key.getXau(): \"" + key.getXau() + "\"");
//                        Log.d(TAG, "mTmpContent: \"" + mTmpContent + "\"");
//                        Log.d(TAG, "tmp: \"" + tmp + "\"");
//                        Log.d(TAG, "-_-result: " + result + "\n");
                        // add lỗi vào listMistake
                        listMistake.add(arrayAllToken.get(i));
                    }
                }
            }
        }
//        Log.d(TAG, "-_-listMistake size: " + listMistake.size());
        mListMisTake = listMistake;
        return listMistake;
    }

    private String removeHtmlTag() {
        String mTmpContent;
        // mContent k thay doi
//        Log.d("TAG", "checkValidParagraph: mContent_before: \"" + mContent + "\"");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mTmpContent = android.text.Html.fromHtml(mContent, FROM_HTML_MODE_COMPACT).toString();
        } else {
            mTmpContent = android.text.Html.fromHtml(mContent).toString();
        }
//        Log.d("TAG", "checkValidParagraph: mContent_after: \"" + mContent + "\"");
        return mTmpContent;
    }

    public Paragraph getContentMarked() {
        // trả lại Paragraph đã được mark bằng cách thay thế toàn bộ các lỗi trong mContent thành <mark>misktake</mark>
        String markedContent = new String(mContent);
        for (int i = 0; i < mListMisTake.size(); i++) {
//            Log.d(TAG, "checkValidParagraph: markedContent.replaceAll: \"" + listMistake.get(i) + "\"");
            markedContent = markedContent.replaceAll(mListMisTake.get(i), "<big><b><font color=\"red\">" + mListMisTake.get(i) + "</font></b></big>");
        }

        Paragraph markedParagraph = new Paragraph(markedContent);
//        if (markedParagraph.getContent().equals(mContent) != true)
//            Log.d(TAG, "checkValidParagraph: markedParagraph: \"" + markedParagraph.getContent() + "\"");
        return markedParagraph;
    }

    public boolean haveMistake() {
        return mListMisTake.size() != 0;
    }

    public String getContent() {
        return mContent;
    }

    @Override
    public String toString() {
        return mContent;
    }

    public Paragraph(String content) {
        mContent = content;
    }

    public Paragraph bigger() {
        mContent = "<big>" + mContent + "</big>";
        return this;
    }

    public Paragraph smaller() {
        mContent = "<small>" + mContent + "</small>";
        return this;
    }

    public Paragraph bold() {
        mContent = "<b>" + mContent + "</b>";
        return this;
    }

    public Paragraph italic() {
        mContent = "<i>" + mContent + "</i>";
        return this;
    }

    public Paragraph h1() {
        mContent = "<h1>" + mContent + "</h1>";
        return this;
    }

    public Paragraph h2() {
        mContent = "<h2>" + mContent + "</h2>";
        return this;
    }

    public Paragraph h3() {
        mContent = "<h3>" + mContent + "</h3>";
        return this;
    }

    public Paragraph h4() {
        mContent = "<h4>" + mContent + "</h4>";
        return this;
    }

    public Paragraph h5() {
        mContent = "<h5>" + mContent + "</h5>";
        return this;
    }

    public Paragraph h6() {
        mContent = "<h6>" + mContent + "</h6>";
        return this;
    }

    public Paragraph subscript() {
        mContent = "<sub>" + mContent + "</sub>";
        return this;
    }

    public Paragraph superscript() {
        mContent = "<sup>" + mContent + "</sup>";
        return this;
    }

    public Paragraph monospaced() {
        mContent = "<tt>" + mContent + "</tt>";
        return this;
    }

    public Paragraph underLine() {
        mContent = "<u>" + mContent + "</u>";
        return this;
    }

    // thuat toan highlight
    private String highlight(String originalString, String textToHighlight) {

        // Construct the formatted text
        String replacedWith = "<font color='red'>" + textToHighlight + "</font>";

        // Replace the specified text/word with formatted text/word
        String modifiedString = originalString.replaceAll(textToHighlight, replacedWith);

        // Update the TextView text
        return modifiedString;
    }

    public String deHighlight(String originalString) {
        String result = originalString.replaceAll("<font color='red'>", "");
        result = result.replaceAll("</font>", "");
        return result;
    }
}

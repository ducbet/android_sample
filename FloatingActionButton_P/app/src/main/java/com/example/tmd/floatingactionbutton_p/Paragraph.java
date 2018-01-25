package com.example.tmd.floatingactionbutton_p;

import java.io.Serializable;

/**
 * Created by tmd on 02/05/2017.
 */

public class Paragraph implements Serializable {
    private String mContent;

    public void clearContentParagraphs() {
        mContent = null;
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
}

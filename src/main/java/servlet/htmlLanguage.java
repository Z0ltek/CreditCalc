package servlet;

import java.io.PrintWriter;

public class htmlLanguage {

    // GLOBAL VARIABLE
    public PrintWriter out;


    public htmlLanguage(){

    }

    public void setPrinter( PrintWriter out ){
        this.out = out;
    }

    // GLOBAL METHOD
    public htmlLanguage print( String arg ){
        out.print( arg );
        return this;
    }

    public htmlLanguage createTable(){
        out.print( "<table style=\"width:100%\" border=\"1\"  >" );
        return this;
    }

    public htmlLanguage closeTable(){
        out.print( "</table>" );
        return this;
    }

    public htmlLanguage startColumn(){
        out.print( "<tr>" );
        return this;
    }

    public htmlLanguage stopColumn(){
        out.print( "</tr>" );
        return this;
    }

    public htmlLanguage startRow(){
        out.print( "<td>" );
        return this;
    }

    public htmlLanguage stopRow(){
        out.print( "</td>" );
        return this;
    }

    public htmlLanguage alert( String arg ){
        out.print( "<script type='text/javascript'>alert('" + arg + "');</script>" );
        return this;
    }

    public htmlLanguage alertAndRedictering( String arg, String page ){
        out.print( ""
                + "<script type='text/javascript'>"
                + "alert('" + arg + "');"
                + "window.location.replace('" + page + "');"
                + "</script>"
        );
        return this;
    }
}
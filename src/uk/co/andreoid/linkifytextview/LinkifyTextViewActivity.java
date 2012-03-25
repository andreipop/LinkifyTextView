package uk.co.andreoid.linkifytextview;

import uk.co.andreoid.linkifytextview.utils.URLSpanNoUnderline;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.widget.TextView;

public class LinkifyTextViewActivity extends Activity {
	
	TextView text1;
	TextView text2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpViews();
        
       
    }

	private void setUpViews() {
		text1 = (TextView) findViewById(R.id.textView1);
		text2 = (TextView) findViewById(R.id.textView2);
		
		text1.setText(
		        Html.fromHtml(
		        		"We got rid of over 60 different privacy policies across Google and replaced them with one that’s a lot shorter and easier to read. " +
		                "<a href=\"http://www.google.co.uk/intl/en/policies\"> Find out more on our website.</a> "));
		        text1.setMovementMethod(LinkMovementMethod.getInstance());
		
		
		text2.setText(
		        Html.fromHtml("Problems singning into your account?"
		        		+ " Visit our " +
		                "<a href=\"http://support.google.com/?hl=en\">Help Centers</a> "
		        		+ " to learn the ins-and-outs of Google products and solve any problems you encounter."));
		        text2.setMovementMethod(LinkMovementMethod.getInstance());
		
		stripUnderlines(text1);
		stripUnderlines(text2);
		        
	}       
	
	private void stripUnderlines(TextView tv) {
		
	    Spannable s = (Spannable)tv.getText();
	    URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
	    
	    for (URLSpan span: spans) {
	        int start = s.getSpanStart(span);
	        int end = s.getSpanEnd(span);
	        s.removeSpan(span);
	        span = new URLSpanNoUnderline(span.getURL());
	        s.setSpan(span, start, end, 0);
	        
	    }
	    
	    tv.setText(s);
	    
	}	
	
}
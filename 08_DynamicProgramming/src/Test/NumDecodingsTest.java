package Test;

import org.junit.Test;
import yang.NumDecodings;

public class NumDecodingsTest {
    NumDecodings NDs = new NumDecodings();
    @  Test
    public void numDecodings() {
        String str = "2611055971756562";
        NDs.numDecodings(str);
    }
}
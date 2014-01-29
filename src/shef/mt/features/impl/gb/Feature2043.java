package shef.mt.features.impl.gb;

import shef.mt.features.util.Sentence;
import shef.mt.features.impl.Feature;
import java.util.*;

/**
 * MOSES: proportion of unknown words
 *
 * @author Catalina Hallett
 *
 */
public class Feature2043 extends Feature {

    public Feature2043() {
        setIndex("2043");
        HashSet res = new HashSet<String>();
        res.add("unknown");
        setResources(res);

        setDescription("MOSES: proportion of unknown words");
    }

    public void run(Sentence source, Sentence target) {
        float unk = new Float((String) source.getValue("unknown")).floatValue();
        int total = source.getNoTokens();
        setValue(unk / total);
    }
}

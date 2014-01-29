/**
 *
 */
package shef.mt.features.impl.bb;

import shef.mt.tools.Giza2;
import java.util.HashSet;
import java.util.StringTokenizer;

import shef.mt.features.impl.Feature;
import shef.mt.features.util.Sentence;
import shef.mt.tools.FileModelOriginal;
import shef.mt.tools.Giza;

/**
 * average number of translations per source word in the sentence (threshold in
 * giza2: prob > 0.01) weighted by the inverse frequency of each word in the
 * source corpus
 *
 * @author Catalina Hallett
 * @author Marco Turchi
 * 
 */
// Code modification for on the fly feature extraction. Modified by Marco Turchi Fondazione Bruno Kessler June 2013.

public class Feature1037 extends Feature {

    final static Float probThresh = 0.01f;

    public Feature1037() {
        setIndex(1037);
        setDescription("average number of translations per source word in the sentence (threshold in giza2: prob > 0.01) weighted by the inverse frequency of each word in the source corpus");
        HashSet res = new HashSet<String>();
        res.add("Giza2");
        res.add("Freq");
        setResources(res);
    }

    /* (non-Javadoc)
     * @see wlv.mt.features.util.Feature#run(wlv.mt.features.util.Sentence, wlv.mt.features.util.Sentence)
     */
    @Override
    public void run(Sentence source, Sentence target) {
        float noTokens = source.getNoTokens();

        float probSum = 0;

        String[] tokens = source.getTokens();
        for (String word : tokens) {
            float freq = FileModelOriginal.getFrequency(word);
            float gizaf = (float) Giza2.getWordProbabilityCount(word, probThresh);

            if (freq != 0) {
                probSum += gizaf / freq;
            }
        }

        if (noTokens == 0) {
            setValue(0);
        } else {
            setValue(probSum / noTokens);
        }
    }
}

/**
 *
 */
package shef.mt.features.impl.bb;

import java.util.HashSet;
import java.util.StringTokenizer;

import shef.mt.features.impl.Feature;
import shef.mt.features.util.Sentence;
import shef.mt.tools.FileModelOriginal;
import shef.mt.tools.Giza;

/**
 * average word frequency: on average, each type (unigram) in the source
 * sentence appears x times in the corpus (in all quartiles)
 *
 * @author Catalina Hallett
 *
 */
public class Feature1061 extends Feature {

    public Feature1061() {
        setIndex(1061);
        setDescription("average word frequency: on average, each type (unigram) in the source sentence appears x times in the corpus (in all quartiles)");
        HashSet res = new HashSet<String>();
        res.add("Freq");
        setResources(res);
    }

    /* (non-Javadoc)
     * @see wlv.mt.features.util.Feature#run(wlv.mt.features.util.Sentence, wlv.mt.features.util.Sentence)
     */
    @Override
    public void run(Sentence source, Sentence target) {
        // TODO Auto-generated method stub

        float noTokens;
        noTokens = source.getNoTokens();

        String[] tokens = source.getTokens();

        float wordSum = 0;
        for (String word : tokens) {
            wordSum += FileModelOriginal.getFrequency(word);
        }

        float result = wordSum / noTokens;
        if (result == 0) {
            setValue(0);
        } else {
            setValue(result);
        }
    }
}

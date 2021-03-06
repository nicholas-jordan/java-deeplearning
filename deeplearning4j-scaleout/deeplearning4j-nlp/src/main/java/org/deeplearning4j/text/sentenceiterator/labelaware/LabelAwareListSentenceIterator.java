package org.deeplearning4j.text.sentenceiterator.labelaware;

import org.deeplearning4j.util.StringGrid;
import org.deeplearning4j.text.sentenceiterator.SentencePreProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Iterates over an input stream with the textual format:
 * label delimiter text
 *
 * @author Adam Gibson
 */
public class LabelAwareListSentenceIterator implements LabelAwareSentenceIterator {

    private int currPosition;
    private List<String> labels;
    private List<String> text;
    private String currentLabel;
    private SentencePreProcessor sentencePreProcessor;

    /**
     * Initializes the sentence iterator with the given args, note that this will close the input stream for you
     * @param is the input stream (this will be closed)
     * @param delimiter the delimiter (tab comma,...)
     * @param labelPosition the position of the label on each line
     * @param textPosition the position of the text on each line
     * @throws IOException
     */
    public LabelAwareListSentenceIterator(InputStream is,String delimiter,int labelPosition,int textPosition) throws IOException {
        StringGrid grid = StringGrid.fromInput(is,delimiter);
        labels = grid.getColumn(labelPosition);
        text = grid.getColumn(textPosition);


        is.close();

    }

    /**
     * Same as calling (is,\t,0,1)
     * @param is the input stream to read lines from
     * @throws IOException
     */
    public LabelAwareListSentenceIterator(InputStream is) throws IOException {
        this(is,"\t",0,1);
    }

    /**
     * Same as calling (is,\t,0,1)
     * @param is the input stream to read lines from
     * @param sep the separator for the file
     * @throws IOException
     */
    public LabelAwareListSentenceIterator(InputStream is,String sep) throws IOException {
        this(is,sep,0,1);
    }




    /**
     * Returns the current label for nextSentence()
     *
     * @return the label for nextSentence()
     */
    @Override
    public synchronized String currentLabel() {
        return currentLabel;
    }

    /**
     * Gets the next sentence or null
     * if there's nothing left (Do yourself a favor and
     * check hasNext() )
     *
     * @return the next sentence in the iterator
     */
    @Override
    public  String nextSentence() {
        String ret = text.get(currPosition);
        currentLabel = labels.get(currPosition);
        if(sentencePreProcessor != null)
            ret = sentencePreProcessor.preProcess(ret);
        currPosition++;
        return ret;
    }

    /**
     * Same idea as {@link java.util.Iterator}
     *
     * @return whether there's anymore sentences left
     */
    @Override
    public synchronized  boolean hasNext() {
        return currPosition < text.size();
    }

    /**
     * Resets the iterator to the beginning
     */
    @Override
    public void reset() {
        currPosition = 0;

    }

    /**
     * Allows for any finishing (closing of input streams or the like)
     */
    @Override
    public void finish() {
         //no op
    }

    @Override
    public SentencePreProcessor getPreProcessor() {
        return sentencePreProcessor;
    }

    @Override
    public void setPreProcessor(SentencePreProcessor preProcessor) {
        this.sentencePreProcessor = preProcessor;
    }
}

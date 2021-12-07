package final_dz.writers;

import org.w3c.dom.Document;

/**
 * Main class for writing information to file
 */
public abstract class MainWriter {

    public abstract void writeDocument(Document document, String path);
}

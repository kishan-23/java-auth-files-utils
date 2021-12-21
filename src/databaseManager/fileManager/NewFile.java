package databaseManager.fileManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewFile {
    private String fileName;
    private String owner;
    private String path;
    private String key;
    private boolean is_new;

    /**
     * Constructor for saving a new file
     * @param fileName Name of the file,
     * @param path Path of the file in Server folder,
     * @param owner User id of the owner.
     */
    public NewFile(String fileName, String path, String owner){
        this.fileName = fileName;
        this.path = path;
        this.owner = owner;
        is_new = true;
    }

    /**
     * Constructor to use for updating an old file
     * @param key file id of the file
     */
    public NewFile(String key){
        this.key = key;
        is_new = false;
    }

    private String generateKey(){
        if(!is_new) return this.key;
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String key = owner+"#"+timeStamp;
        return key;
    }

    public boolean save(){
        return true;
    }

    public boolean update(){
        return true;
    }
}

package databaseManager.fileManager;

import java.io.Serializable;
import java.util.Date;

public class FileDetails implements Serializable {
     private String fileName;
     private long fileSize;
     private String owner;
     private String fileId;
     private Date creationDate;
     private Date modifiedDate;

     public FileDetails(String fileName, long size, String owner, String id, Date c_date, Date m_date){
         this.fileId = id;
         this.fileName = fileName;
         this.fileSize = size;
         this.owner = owner;
         this.creationDate = c_date;
         this.modifiedDate = m_date;
     }

    public String getFileName() {
        return fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public long getFileSize() {
        return fileSize;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public String getOwner() {
        return owner;
    }
}

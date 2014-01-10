package io.github.xhanin.jarup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Date: 10/1/14
 * Time: 17:43
 */
public class IOUtils {
    public static void delete(File f) throws IOException {
        if (f.isDirectory()) {
            for (File c : f.listFiles())
                delete(c);
        }
        if (!f.delete())
            throw new FileNotFoundException("Failed to delete: " + f.getAbsolutePath());
    }

    public static String toString(File file, Charset charset) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return charset.decode(ByteBuffer.wrap(encoded)).toString();
    }
}

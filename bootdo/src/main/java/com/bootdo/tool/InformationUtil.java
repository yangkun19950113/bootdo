package com.bootdo.tool;

import com.deepoove.poi.XWPFTemplate;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Map;

public class InformationUtil {

    public static String  fileAccordingData(String templateFileName ,String targetDataFileName ,Map<String, String> dataMap) throws IOException {
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        XWPFTemplate template = XWPFTemplate.compile(templateFileName).render(dataMap);

        try {
            FileOutputStream out = new FileOutputStream(targetDataFileName);//要导出的文件名
            template.write(out);
            out.flush();
            out.close();
            template.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return targetDataFileName;

    }

    public static void docxToHtml(String sourceDocFileName ,String targetHtmlFileName) throws IOException {
        OutputStreamWriter outputStreamWriter = null;
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(sourceDocFileName));

            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetHtmlFileName), "utf-8");
            XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
            xhtmlConverter.convert(document, outputStreamWriter, null);

        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

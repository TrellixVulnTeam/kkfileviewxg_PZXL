package cn.keking.service.impl;

import cn.keking.model.FileAttribute;
import cn.keking.service.FilePreview;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * @author kl (http://kailing.pub)
 * @since 2021/2/18
 */
@Component
public class CodeFilePreviewImpl implements FilePreview {

   private final SimTextFilePreviewImpl filePreviewHandle;

    public CodeFilePreviewImpl(SimTextFilePreviewImpl filePreviewHandle) {
        this.filePreviewHandle = filePreviewHandle;
    }

    @Override
    public String filePreviewHandle(String url, Model model, FileAttribute fileAttribute) {
         filePreviewHandle.filePreviewHandle(url, model, fileAttribute);
        String suffix = fileAttribute.getSuffix();
        if(suffix.equalsIgnoreCase("htm") || suffix.equalsIgnoreCase("html") ||suffix.equalsIgnoreCase("shtml") ){
            model.addAttribute("pdfUrl", url);
            return  EXEL_FILE_PREVIEW_PAGE;   //直接输出html
        }
        return CODE_FILE_PREVIEW_PAGE;
    }
}

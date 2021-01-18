package editor;

import app.Main;
import core.Editor;
import error.ErrorEnum;
import gui.rightPanelView.slotContent.ImageContent;
import gui.rightPanelView.slotContent.TextContent;
import gui.view.MainView;
import repository.slot.Slot;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditorImplementation implements Editor {
    File file=null;

    @Override
    public void choseContentType(Slot slot) {
        JDialog jDialog=new JDialog();
        jDialog.setLayout(new FlowLayout());
        jDialog.setSize(250,120);
        jDialog.setTitle("Choose slot's content type:");
        JButton textButton=new JButton();
        Icon icon=new ImageIcon("images/text.png");
        textButton.setIcon(icon);
        JButton imageButton=new JButton();
        Icon iconimg=new ImageIcon("images/imagecontent.png");
        imageButton.setIcon(iconimg);

        final EditorEnum[] ret = new EditorEnum[1];

        ret[0]=null;

        textButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            jDialog.setVisible(false);
                Main.getInstance().getEditor().openTextContent(slot);
            }
        });

        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.setVisible(false);
                Main.getInstance().getEditor().openImageContent(slot);

            }
        });
        jDialog.add(textButton);
        jDialog.add(imageButton);
        jDialog.setVisible(true);
        jDialog.setResizable(false);


    }

    @Override
    public void openImageContent(Slot slot) {
        JDialog jDialog=new JDialog();
        jDialog.setLayout(new BorderLayout());
        jDialog.setSize(700,700);
        jDialog.setResizable(true);
        JPanel imageView=new JPanel();
        JToolBar tb=new JToolBar();
        tb.setFloatable(false);

        JButton save=new JButton("SAVE");

        JButton uploadImage=new JButton("Upload image");
        uploadImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser=new JFileChooser();
                FileNameExtensionFilter extension=new FileNameExtensionFilter("slika.jpg","jpg");
                chooser.setFileFilter(extension);
                int ret=chooser.showOpenDialog(jDialog);
                if(ret==JFileChooser.APPROVE_OPTION){
                    file=new File(chooser.getSelectedFile().getAbsoluteFile().toString());
                    Image img=null;
                    try {
                         img=ImageIO.read(chooser.getSelectedFile().getAbsoluteFile());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    ImageIcon imageIcon=new ImageIcon(img);
                    JLabel preview=new JLabel(imageIcon);
                    imageView.removeAll();
                    imageView.add(preview);
                    jDialog.revalidate();
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(file!=null) {
                    ImageContent newimg = new ImageContent();
                    newimg.setType(EditorEnum.IMAGE);
                    newimg.setImage(file);
                    slot.setSlotContent(newimg);
                    jDialog.setVisible(false);
                }else{
                    Main.getInstance().getErrorHandler().generateError(ErrorEnum.ERROR_NOTHINGTOSAVE);

                }
            }
        });

        tb.add(save);
        tb.add(uploadImage);
        jDialog.add(tb,BorderLayout.NORTH);
        jDialog.add(imageView,BorderLayout.CENTER);

        if(slot.getSlotContent()!=null){
            ImageContent imageContent= (ImageContent) slot.getSlotContent();
            JLabel prv=null;
            try{
                Image load = ImageIO.read(imageContent.getImage().getAbsoluteFile());
                prv=new JLabel(new ImageIcon(load));
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageView.removeAll();
            imageView.add(prv);
            jDialog.revalidate();
        }

        jDialog.setVisible(true);

    }

    @Override
    public void openTextContent(Slot slot) {
        JDialog jDialog=new JDialog();
        jDialog.setLayout(new BorderLayout());
        jDialog.setSize(500,300);

        JToolBar tb=new JToolBar();
        tb.setFloatable(false);

        JButton bold=new JButton(new StyledEditorKit.BoldAction());
        Icon bimg=new ImageIcon("images/bold.png");
        bold.setText("");
        bold.setIcon(bimg);

        JButton italic=new JButton(new StyledEditorKit.ItalicAction());
        Icon iimg=new ImageIcon("images/italic.png");
        italic.setText("");
        italic.setIcon(iimg);

        JButton underline=new JButton(new StyledEditorKit.UnderlineAction());
        Icon uimg=new ImageIcon("images/underline.png");
        underline.setText("");
        underline.setIcon(uimg);

        JTextPane textArea=new JTextPane();
        textArea.setContentType("text/html");

        JButton save=new JButton("SAVE");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textArea.getText().length()>110) {
                    TextContent newt = new TextContent();
                    newt.setType(EditorEnum.TEXT);
                    newt.setText(textArea.getText());
                    slot.setSlotContent(newt);
                    jDialog.setVisible(false);
                }else{
                    Main.getInstance().getErrorHandler().generateError(ErrorEnum.ERROR_NOTHINGTOSAVE);


                }

            }
        });

        tb.add(bold);
        tb.add(italic);
        tb.add(underline);
        tb.addSeparator();
        tb.add(save);

        jDialog.add(tb,BorderLayout.NORTH);
        jDialog.add(textArea,BorderLayout.CENTER);

        if(slot.getSlotContent()!=null){

            textArea.setText(((TextContent)slot.getSlotContent()).getText());
        }

        jDialog.setVisible(true);


    }
}

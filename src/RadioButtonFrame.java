import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonFrame extends JFrame {
    private JTextField txtfPalavra;
    private JRadioButton rdnPlain;
    private JRadioButton rdnBold;
    private JRadioButton rdnItalic;
    private JRadioButton rdnBoldItalic;
    private ButtonGroup group;
    private Font plainFont;
    private Font boldFont;
    private Font italicFont;
    private Font boldItalicFont;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    RadioButtonFrame frame = new RadioButtonFrame();
                    frame.setVisible(true);
                }
                catch (Exception ex){
                    ex.getStackTrace();
                }
            }
        });
    }
    public RadioButtonFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 200);
        setLayout(new FlowLayout());

        txtfPalavra = new JTextField("Watch the fon style change", 25);
        add(txtfPalavra);

        rdnPlain = new JRadioButton("Plain", true);
        rdnBold = new JRadioButton("Bold", false);
        rdnItalic = new JRadioButton("Italic", false);
        rdnBoldItalic = new JRadioButton("Bold/Italic", false);
        add(rdnPlain);
        add(rdnBold);
        add(rdnItalic);
        add(rdnBoldItalic);

        group = new ButtonGroup();
        group.add(rdnPlain);
        group.add(rdnBold);
        group.add(rdnItalic);
        group.add(rdnBoldItalic);

        plainFont = new Font("serif", Font.PLAIN, 14);
        boldFont = new Font("serif", Font.BOLD, 14);
        italicFont = new Font("serif", Font.ITALIC, 14);
        boldItalicFont = new Font("serif", Font.BOLD + Font.ITALIC, 14);

        rdnPlain.addItemListener(new RadioButtonHandler(plainFont));
        rdnBold.addItemListener(new RadioButtonHandler(boldFont));
        rdnItalic.addItemListener(new RadioButtonHandler(italicFont));
        rdnBoldItalic.addItemListener(new RadioButtonHandler(boldItalicFont));
    }
    private class RadioButtonHandler implements ItemListener {
        private Font font;
        public RadioButtonHandler(Font f) {
            font = f;
        }
        public void itemStateChanged(ItemEvent event){
            txtfPalavra.setFont(font);
        }
    }
}

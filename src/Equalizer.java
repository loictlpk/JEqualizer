import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Equalizer extends JFrame{
    private JSlider freqSliderLow;
    private JSlider freqSliderMid;
    private JSlider freqSliderHigh;
    private JCheckBox midCheckBox;
    private JCheckBox lowCheckBox;
    private JSlider vSliderHigh;
    private JSlider vSliderMid;
    private JSlider vSliderLow;
    private JSlider qSliderLow;
    private JSlider qSliderMid;
    private JPanel eqUi;
    private JSlider qSliderHigh;
    private JCheckBox highCheckBox;
    private JLabel lowValue;
    private JLabel midValue;
    private JLabel highValue;

    public static void getAllInfos(Frequency l, Frequency m, Frequency h){
        l.getInfo();
        m.getInfo();
        h.getInfo();
    }

    public Equalizer(){

        Frequency low = new Frequency("low",200, 0,0, 200);
        Frequency mid = new Frequency("mid",2500, 0, 200, 2000);
        Frequency high = new Frequency("high",12000, 0, 2000, 20000);
        getAllInfos(low, mid, high);

        freqSliderLow.setMinimum(low.getMinFreqRange());
        freqSliderLow.setMaximum(low.getMaxFreqRange());
        freqSliderLow.setValue((int)low.getHz());
        lowValue.setText(String.valueOf((float)freqSliderLow.getValue()) + " hz");

        freqSliderMid.setMinimum(mid.getMinFreqRange());
        freqSliderMid.setMaximum(mid.getMaxFreqRange());
        freqSliderMid.setValue((int) mid.getHz());
        midValue.setText(String.valueOf((float)freqSliderMid.getValue()) + " hz");

        freqSliderHigh.setMinimum(high.getMinFreqRange());
        freqSliderHigh.setMaximum(high.getMaxFreqRange());
        freqSliderHigh.setValue((int) high.getHz());
        highValue.setText(String.valueOf((float)freqSliderHigh.getValue()) + " hz");

        setContentPane(eqUi);
        setTitle("JEqualizer");
        setSize(1299, 369);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        lowCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lowCheckBox.isSelected()){
                    low.setEnable(false);
                    System.out.println("Low Freq OFF");
                }
                else{
                    low.setEnable(true);
                    System.out.println("Low Freq ON");
                }

            }
        });
        midCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(midCheckBox.isSelected()){
                    mid.setEnable(false);
                    System.out.println("Mid Freq OFF");
                }
                else{
                    mid.setEnable(true);
                    System.out.println("Mid Freq ON");
                }
            }
        });
        highCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(highCheckBox.isSelected()){
                    high.setEnable(false);
                    System.out.println("High Freq OFF");
                }
                else{
                    high.setEnable(true);
                    System.out.println("High Freq ON");
                }
            }
        });

        freqSliderLow.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                low.setHz(freqSliderLow.getValue());
                low.getInfo();
                lowValue.setText(String.valueOf(low.getHz()) + " hz");
            }
        });
    }
}

package action;

import factory.ObjectFactory;
import service.serviceProxy.FlightServiceProxyImp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static action.Who.flight;

public class ModifyFlightFrame {
    private JFrame jf;

    private JLabel jLabelFlightId;
    private JLabel jLabelBeginAddress;
    private JLabel jLabelEndAddress;
    private JLabel jLabelBeginTime;
    private JLabel jLabelTime;
    private JLabel jLabelAvailableTickets;
    private JLabel jLabelPrice;

    private JTextField jTextFlightId;
    private JTextField jTextBeginAddress;
    private JTextField jTextEndAddress;
    private JTextField jTextBeginTime;
    private JTextField jTextTime;
    private JTextField jTextAvailableTickets;
    private JTextField jTextPrice;

    private JButton JBEnter;

    ModifyFlightFrame() {
        jf = new JFrame("修改航班");

        jLabelFlightId = new JLabel("航班号   ");
        jLabelBeginAddress = new JLabel("出发地   ");
        jLabelEndAddress = new JLabel("目的地   ");
        jLabelBeginTime = new JLabel("起飞时间");
        jLabelTime = new JLabel("飞行时长");
        jLabelAvailableTickets = new JLabel("余票     ");
        jLabelPrice = new JLabel("票价     ");

        jTextFlightId = new JTextField(10);
        jTextBeginAddress = new JTextField(10);
        jTextEndAddress = new JTextField(10);
        jTextBeginTime = new JTextField(10);
        jTextTime = new JTextField(10);
        jTextAvailableTickets = new JTextField(10);
        jTextPrice = new JTextField(10);

        JBEnter = new JButton("修改");

    }

    private void init() {

        jf.add(jLabelFlightId);
        jf.add(jTextFlightId);

        jf.add(jLabelBeginAddress);
        jf.add(jTextBeginAddress);

        jf.add(jLabelEndAddress);
        jf.add(jTextEndAddress);

        jf.add(jLabelBeginTime);
        jf.add(jTextBeginTime);

        jf.add(jLabelTime);
        jf.add(jTextTime);

        jf.add(jLabelAvailableTickets);
        jf.add(jTextAvailableTickets);

        jf.add(jLabelPrice);
        jf.add(jTextPrice);

        jf.add(JBEnter);

    }

    private void initData() {
        jTextFlightId.setText(flight.getFlightId());
        jTextBeginAddress.setText(flight.getBeginAddress());
        jTextEndAddress.setText(flight.getEndAddress());
        jTextBeginTime.setText(flight.getBeginTime());
        jTextTime.setText(flight.getTime().toString());
        jTextAvailableTickets.setText(flight.getAvailableTickets().toString());
        jTextPrice.setText(flight.getPrice().toString());
    }

    private void handle() {

        JBEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                * 调用修改的方法
                * */
                FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp) ObjectFactory.getObject("FlightServiceProxyImp");

                flight.setFlightId(jTextFlightId.getText());
                flight.setBeginAddress(jTextBeginAddress.getText());
                flight.setBeginTime(jTextBeginTime.getText());
                flight.setEndAddress(jTextEndAddress.getText());
                flight.setTime(Integer.parseInt(jTextTime.getText()));
                flight.setAvailableTickets(Integer.parseInt(jTextAvailableTickets.getText()));
                flight.setPrice(Float.parseFloat(jTextPrice.getText()));
                flightServiceProxyImp.flightModify(flight);
                JOptionPane.showMessageDialog(jf,"修改成功,请刷新");
                JOptionPane.getFrameForComponent(jf).dispose();
            }
        });
    }


    void show() {
        init();
        initData();
        handle();
        jf.setLayout(new FlowLayout());
        jf.setBounds(300, 300, 223, 338);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ModifyFlightFrame().show();
    }
}

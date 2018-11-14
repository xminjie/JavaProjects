package action;

import entity.Flight;
import factory.ObjectFactory;
import service.serviceProxy.FlightServiceProxyImp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFlightFrame {
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

    private JButton JBEnter, JBClear;

    AddFlightFrame() {
        jf = new JFrame("添加航班");

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

        JBClear = new JButton("重置");
        JBEnter = new JButton("确定");

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

        jf.add(JBClear);
        jf.add(JBEnter);

    }

    private void handle() {
        JBClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFlightId.setText(null);
                jTextBeginAddress.setText(null);
                jTextEndAddress.setText(null);
                jTextBeginTime.setText(null);
                jTextTime.setText(null);
                jTextAvailableTickets.setText(null);
                jTextPrice.setText(null);
            }
        });

        JBEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp) ObjectFactory.getObject("FlightServiceProxyImp");
                Flight flight = new Flight();
                flight.setFlightId(jTextFlightId.getText());
                flight.setBeginAddress(jTextBeginAddress.getText());
                flight.setBeginTime(jTextBeginTime.getText());
                flight.setEndAddress(jTextEndAddress.getText());
                flight.setTime(Integer.parseInt(jTextTime.getText()));
                flight.setAvailableTickets(Integer.parseInt(jTextAvailableTickets.getText()));
                flight.setPrice(Float.parseFloat(jTextPrice.getText()));
//                flightServiceProxyImp.flightAdd(flight);
                if(flightServiceProxyImp.flightAdd(flight) != null) {
                    JOptionPane.showMessageDialog(jf, "添加成功");
                    JOptionPane.getFrameForComponent(jf).dispose();
                }else{
                    JOptionPane.showMessageDialog(jf, "航班已存在");
                }
            }
        });
    }


    void show() {
        init();
        handle();
        jf.setLayout(new FlowLayout());
        jf.setBounds(300, 300, 223, 338);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AddFlightFrame().show();
    }
}

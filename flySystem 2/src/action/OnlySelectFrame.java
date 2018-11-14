package action;

import entity.Flight;
import factory.ObjectFactory;
import service.serviceProxy.FlightServiceProxyImp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

class OnlySelectFrame {
    private JFrame jf;

    private JTable jTable;

    private JPanel panelN;
    private JPanel panelS;

    private JButton JBBuy;
    private JButton JBQuery;
    private JButton JBRecorder;

    private JLabel JLFlight, JLBegin, JLEnd;

    private JTextField JTFlight, JTBegin, JTEnd;


    OnlySelectFrame() {
        jf = new JFrame();

        jTable = new JTable();

        panelN = new JPanel();
        panelS = new JPanel();

        JLFlight = new JLabel("航班号");
        JLBegin = new JLabel("出发地");
        JLEnd = new JLabel("目的地");

        JTFlight = new JTextField(10);
        JTBegin = new JTextField(10);
        JTEnd = new JTextField(10);


        JBBuy = new JButton("购票");
        JBQuery = new JButton("查询余票");
        JBRecorder = new JButton("我的订单");

    }

    private void init() {
        panelS.add(JBQuery);

        panelN.add(JLFlight);
        panelN.add(JTFlight);

        panelN.add(JLBegin);
        panelN.add(JTBegin);

        panelN.add(JLEnd);
        panelN.add(JTEnd);


        JScrollPane jsp = new JScrollPane(jTable);
        jf.add(jsp);

        jf.add(panelN, BorderLayout.NORTH);
        jf.add(panelS, BorderLayout.SOUTH);

    }

    private void initData() {
        FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp)ObjectFactory.getObject("FlightServiceProxyImp");
        addData(flightServiceProxyImp.queryAll());
    }


    private void addData(List<Flight> list) {
        DefaultTableModel def = new DefaultTableModel();
        def.addColumn("航班号");
        def.addColumn("出发地");
        def.addColumn("目的地");
        def.addColumn("出发时间");
        def.addColumn("行程时间");
        def.addColumn("余票");
        def.addColumn("票价");

        for(int i = 0; i < list.size(); i++){
            Flight f = list.get(i);
            Vector<Object> v = new Vector<>();
            v.add(f.getFlightId());
            v.add(f.getBeginAddress());
            v.add(f.getEndAddress());
            v.add(f.getBeginTime());
            v.add(f.getTime());
            v.add(f.getAvailableTickets());
            v.add(f.getPrice());
            def.addRow(v);
        }
        jTable.setModel(def);
    }

    private void actionHandle() {
        JBBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JBRecorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyRecorderFrame().show();
            }
        });
        JBQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp) ObjectFactory.getObject("FlightServiceProxyImp");
                Flight f = new Flight();
                f.setFlightId(JTFlight.getText());
                f.setBeginAddress(JTBegin.getText());
                f.setEndAddress(JTEnd.getText());
                OnlySelectFrame.this.addData(flightServiceProxyImp.queryAll(f));
            }
        });

    }

    public void show(String name) {
        jf.setTitle(name);
        init();
        initData();
        actionHandle();
//        jf.setLayout(new FlowLayout());
        jf.setBounds(300, 300, 737, 421);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new OnlySelectFrame().show("游客查询");
    }
}

package gymnastics_management;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JLayeredPane.DEFAULT_LAYER;
import static javax.swing.JLayeredPane.DRAG_LAYER;

public class SignUp
{
    JTabbedPane tabbedPane;//选项卡
    public void signupwindow()
    {
        JFrame frame=new JFrame("个人中心");
        JLayeredPane layeredPane=new JLayeredPane();

        //屏幕大小
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screensize.getWidth();
        int height = (int)screensize.getHeight();

        //填写报名信息界面
        JPanel spinfo=new JPanel();
        JScrollPane signupinfo=new JScrollPane(spinfo);

        //查看报名信息界面
        JPanel vspinfo=new JPanel();
        JScrollPane viewsignupinfo=new JScrollPane(vspinfo);

        //添加到选项卡中
        tabbedPane=new JTabbedPane(JTabbedPane.LEFT);

        tabbedPane.addTab("填写报名信息",signupinfo);
        tabbedPane.addTab("查看报名信息",viewsignupinfo);

        //填写报名信息

        //背景图片
        ImageIcon logininpicture=new ImageIcon("logininpicture.jpg");
        logininpicture.setImage(logininpicture.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        JLabel bgpicturel = new JLabel(logininpicture);
        JPanel bgpicture=new JPanel();
        bgpicture.add(bgpicturel);
        bgpicture.setBounds(0,0,width,height);

        //添加到分层器上
        //layeredPane.add(bgpicture,DEFAULT_LAYER);
        //layeredPane.add(tabbedPane,DRAG_LAYER);

        frame.getContentPane().add(tabbedPane,BorderLayout.CENTER);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SignUp signUp=new SignUp();
        signUp.signupwindow();
    }
}

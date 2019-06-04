# 電子時鐘

---

**電腦配置:**

- Eclipse Oxygen
- JDK-8u111

**檔案:**

1. DigitalLabel
2. Digital_Clock

**類別解析:**

- SimpleDateFormat:
  SimpleDateFormat is a concrete class for formatting and parsing dates in a locale-sensitive manner. It allows for formatting (date -> text), parsing (text -> date), and normalization.
  SimpleDateFormat是一個具象類別，用來格式化和解析 區域設置的日期方式 。 它允許格式化（日期 - >文本），解析（文本 - >日期）和規範化。

- javax.swing.Timer.Timer(int delay, ActionListener listener):
  在指定毫秒時間間隔觸發一個或多個 監聽器，

- java.awt.event.ActionListener actionPerformed():
  ActionListener 介面 (interface) 的 actionPerformed() 方法 (method) 用來設定按下按鈕後的動作。

- java.awt.TextComponent setText():
  TextComponent 類別 (class) 的 setText() 方法 (method) 用來設定文字輸入框的文字。
  Java API 分類導覽 - java.awt.TextComponent setText()

- Concrete Class:
  concrete class 和 abstract classes 相反，一個類別其設計之主要目的就是要讓人產生instance，則稱此類別為concrete class。實務上只要是能產生instance的類別都稱之為concrete classes。



## DigitalLabel

---

```java
    package Label;
    
    import java.awt.BorderLayout;
    import java.awt.EventQueue;
    import java.awt.Font;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.border.EmptyBorder;
    import javax.swing.BoxLayout;
    import java.awt.CardLayout;
    import java.awt.Color;
    
    import javax.swing.JSplitPane;
    import javax.swing.SwingConstants;
    import javax.swing.Timer;
    
    public class DigitalLabel extends JLabel implements ActionListener 
    {
    	/*field*/
    	String type;/*供給Digital_Clock要呼叫的 date, time, day*/
    	SimpleDateFormat sdf;
    
        /*Constructor Parameters*/
        /*供Digital_Clock來呼叫*/
    	public DigitalLabel(String type) 
    	{
    		this.type = type;
            /*設定視窗或元件的【前景】顏色*/
    		setForeground(Color.green);
    
            /*switch條件式，case分成date(年月日),time(時分秒),day(星期)*/
    		switch (type) {
    		case "date":
                    /*date要格式化的字串格式("  MMMM / dd / yyyy")*/
    			sdf = new SimpleDateFormat("  MMMM / dd / yyyy");
    			setFont(new Font("sans-serif", Font.PLAIN, 12));
                    /*設定水平方向的對齊 置左*/
    			setHorizontalAlignment(SwingConstants.LEFT);
    			break;
    		case "time":
                    /*time要格式化的字串格式("hh:mm:ss a")*/
    			sdf = new SimpleDateFormat("hh:mm:ss a");
    			setFont(new Font("sans-serif", Font.PLAIN, 40));
               		/*設定水平方向的對齊 置中*/
    			setHorizontalAlignment(SwingConstants.CENTER);
    			break;
    		case "day":
                    /*day要格式化的字串格式("EEEE  ")*/
    			sdf = new SimpleDateFormat("EEEE  ");
    			setFont(new Font("sans-serif", Font.PLAIN, 16));
                    /*設定水平方向的對齊 置右*/
    			setHorizontalAlignment(SwingConstants.RIGHT);
    			break;
    		default:
    			sdf = new SimpleDateFormat();
    			break;
    		}
            /*new Timer建構子; 1000毫秒=1秒; 啟動this(type)監聽器*/
    		Timer t = new Timer(1000, this);
    		t.start();
    	}
    		/*參數e 是ActionEvent的物件*/
    	public void actionPerformed(ActionEvent e) 
        {
        	/*初始化叫d的Date物件*/
    		Date d = new Date();
    		/*要顯示的內容(格式化後的時間)*/
    		setText(sdf.format(d));
    	}
    }

```



Digital_Clock

---
```java
    import java.awt.Color;
    import java.awt.GridLayout;
    
    import javax.swing.JFrame;
    
    import Label.*;
    
    public class Digital_Clock {
    	public static void main(String[] args) {
            
            /*初始化DigitalLabel類別物件*/
    		DigitalLabel date = new DigitalLabel("date");
    		DigitalLabel time = new DigitalLabel("time");
    		DigitalLabel day = new DigitalLabel("day");
    		
    		JFrame.setDefaultLookAndFeelDecorated(true);
    		JFrame f = new JFrame("Digital Clock");
    		f.setSize(300,150);
    		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		f.setLayout(new GridLayout(3,1));
    		
            /*JFrame呼叫DigitalLabel的物件*/
    		f.add(date);
    		f.add(time);
    		f.add(day);
    		
            /*設定背景顏色*/
    		f.getContentPane().setBackground(Color.black);
    		
            /*設定元件的可見性*/
    		f.setVisible(true);
    	}
    }

```



## Reference:

---

https://www.hollischuang.com/archives/3017

https://zy-email1991.iteye.com/blog/2243021

https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html

https://pydoing.blogspot.com/2012/03/java-api-setforeground.html

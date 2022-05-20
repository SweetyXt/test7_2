import java.util.Objects;
import java.util.HashMap;
import java.util.Scanner;

//单词模型类
class Word {
    private String name;
    private String meaning;

    public Word() {
    }

    public Word(String name, String meaning) {
        this.name = name;
        this.meaning = meaning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(name, word.name) && Objects.equals(meaning, word.meaning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, meaning);
    }
}


//CURD
class Dictionary {
    private HashMap<String, Word> ch = null;
    private HashMap<String, Word> en = null;

    //初始化
    public Dictionary() {
        this.ch = new HashMap<String, Word>();
        this.en = new HashMap<String, Word>();
    }

    //添加中文单词
    public void addChWord() {
        System.out.println("请输入单词名称");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        if (ch.containsKey(name)) {
            System.out.println("这个单词已存在，请重试");
        } else {
            System.out.println("请输入这个单词的英文翻译");
            String meaning = sc.next();
            ch.put(name, new Word(name, meaning));
            System.out.println("添加成功");
        }
        backMenu();
    }

    //添加英文单词
    public void addEnWord() {
        System.out.println("请输入单词名称");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        if (en.containsKey(name)) {
            System.out.println("这个单词已存在，请重试");
        } else {
            System.out.println("请输入这个单词的中文翻译");
            String meaning = sc.next();
            en.put(name, new Word(name, meaning));
            System.out.println("添加成功");
        }
        backMenu();
    }

    //改变中文单词
    public void changeCh() {
        System.out.println("请输入您要修改的中文单词");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        boolean flag = ch.containsKey(name);
        if (!flag) {
            System.out.println("您要修改的中文单词不存在，请输入任意字母返回");
            sc.next();
        } else {
            System.out.println("请输入修改后的内容");
            String meaning = sc.next();
            ch.put(name, new Word(name, meaning));
            System.out.println("修改成功");
        }

        backMenu();
    }

    //改变英文单词
    public void changeEn() {
        System.out.println("请输入您要修改的英文单词");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        boolean flag = en.containsKey(name);
        if (!flag) {
            System.out.println("您要修改的英文单词不存在，请输入任意字母返回");
            sc.next();
        } else {
            System.out.println("请输入修改后的内容");
            String meaning = sc.next();
            en.put(name, new Word(name, meaning));
            System.out.println("修改成功");
        }
        backMenu();
    }

    //删除中文单词
    public void deleteCh() {
        System.out.println("请输入您要删除的中文单词");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        if (ch.remove(name) != null)
            System.out.println("删除成功");
        else
            System.out.println("您要删除的单词不存在，请重试");
        backMenu();
    }

    //删除英文单词
    public void deleteEn() {
        System.out.println("请输入您要删除的英文单词");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        if (en.remove(name) != null)
            System.out.println("删除成功");
        else
            System.out.println("您要删除的单词不存在，请重试");
        backMenu();
    }

    //查询中文单词的翻译
    public void seachEn() {
        System.out.println("请输入您要查询的中文单词");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        boolean flag = ch.containsKey(name);
        if (!flag) {
            System.out.println("您要查询的中文单词不存在,请重试");
        } else {
            Word word = ch.get(name);
            System.out.println(name + "的英文翻译是" + word.getMeaning());
        }
        backMenu();
    }

    //查询英文单词的中文翻译
    public void seachCh() {
        System.out.println("请输入您要查询的英文单词");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        boolean flag = en.containsKey(name);
        if (!flag) {
            System.out.println("您要查询的英文单词不存在,请重试");
        } else {
            Word word = en.get(name);
            System.out.println(name + "的中文翻译是" + word.getMeaning());
        }
        backMenu();
    }

    public void backMenu() {
        System.out.println("请输入9返回菜单");
        Scanner sc = new Scanner(System.in);
        sc.next();
        System.out.println();
    }
}


//测试类
public class MainClass {
    public static void main(String[] args) {
        Dictionary myDictionary = new Dictionary();
        while (true) {
            System.out.println("————————欢迎使用中英文词典系统————————");
            System.out.println("1.添加中文单词");
            System.out.println("2.添加英文单词");
            System.out.println("3.修改中文单词");
            System.out.println("4.修改英文单词");
            System.out.println("5.删除中文单词");
            System.out.println("6.删除英文单词");
            System.out.println("7.查询中文单词翻译");
            System.out.println("8.查询英文单词翻译");
            System.out.println("9.退出系统");
            System.out.println("请输入你的选择：");


            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    myDictionary.addChWord();
                    break;
                case 2:
                    myDictionary.addEnWord();
                    break;
                case 3:
                    myDictionary.changeCh();
                    break;
                case 4:
                    myDictionary.changeEn();
                    break;
                case 5:
                    myDictionary.deleteCh();
                    break;
                case 6:
                    myDictionary.deleteEn();
                    break;
                case 7:
                    myDictionary.seachEn();
                    break;
                case 8:
                    myDictionary.seachCh();
                    break;
                case 9:
                    System.out.println("谢谢使用");
                    System.exit(0);
            }
        }
    }
}
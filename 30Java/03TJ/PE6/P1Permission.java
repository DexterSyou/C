
public class P1Permission {


    public static void main(String []args){

      //Sundae x = new Sundae();
	    Sundae x = Sundae.makeASundae();
        //助手方法private ，c的内部链接

    }

}

class Sundae{
	private Sundae(){}
	static Sundae makeASundae(){
	  return new Sundae();
	}
}

/*
 * 包：
 *    每个编译单元只能有一个public类，该编译单元之外额外的类包之外无法看见，是为public类提供支持的
 *    java可运行程序 是一组可以打包并压缩为一个java文档文件（JAR）的.class文件。
 *    java解释器负责这些文件的查找，装载和解释。
 *
 *    package access；必须为第一句
 *    import access；将单一的全局名字空间分割开
 *
 *    java解释器运行过程：
 *        1.环境变量CLASSPATH
 *        2.用作查找.class文件的根目录（CLASSPATH中有多个目录）
 *        3.解释器获取包的名称并将每个句点替换成反斜杠
 *        4.解释器在路径中查找.class文件
 *
 *  public     : 都可以访问
 *  protected  :
 *  private    : 
 *  包访问权限 : 同一个包下可以相互访问
 *    仅控制它所修饰的特定定义的访问权
 *    客户端程序员无法访问包访问权限的（默认的访问权限）
 *
 *
 *  接口与实现：
 *
 */

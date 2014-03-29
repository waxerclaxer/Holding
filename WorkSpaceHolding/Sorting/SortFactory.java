/*
 * Created on Nov 28, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package sorting2014;
import java.lang.reflect.*;
/**
 * @author rcs
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
@SuppressWarnings("unchecked")
public class SortFactory {
	
	public static Sorter getSorter()
	{
		return new BubbleSort();
	}
	
	public static Sorter getSorter(String sorter)
	{
		Sorter sort=null;
		try {
			Class clas = Class.forName(sorter);
			Class[] parms={};
			Constructor cons=clas.getConstructor(parms);
			Object obj = cons.newInstance();
			if (obj instanceof Sorter)
			{
				sort=(Sorter)obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sort;
	}

}

package Tools;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * @author: 何健聪
 * @createTime: 2019/6/4 18:28
 * @version: 1.0
 * @description:
 */
public class JsonReadUtil {

    public String readJSONString(HttpServletRequest request){
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }
}

/**
 * <title>将对象转成JSON格式</title> <code>对象格式Object["A"=a,"B"=b]</code>
 * @author LiFX
 * @version 1.0
 * @date 2015-03-11
 * @param obj 将要参与转换的对象
 * @param arr 不要转换到JSON中的字段
 * @returns
 */
function convertObjToJson(obj, arr) {
	var jsonStr = "";
	for (x in obj) {
		if (x in arr) {
			continue;
		}
		jsonStr += "'" + x + "':" + "'" + obj[x] + "',"
	}
	var json = eval("(" + jsonStr + ")");
	return json;
}
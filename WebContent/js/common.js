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
/**
 * 字符串首字母大写
 * @param str 需要大写的字符串
 * @author   li 
 * @date     2016-03-16 14:44:20
 * @version  1.0 
 * @see      http://blog.csdn.net/apensu/article/details/7332776    
 * @returns
 */
function strFirstUper(str)
{
	return str.replace(/\b(\w)|\s(\w)/g, function(m){  
        return m.toUpperCase();  
    });    
}

/**
 * 
 *<title>将单词中的非开头的大写字母替换成小写字母并将前面加上下划线<title>
 *<code>helloWord->hello_word<code>
 * @author   li 
 * @date     2016-03-17 14:12:04
 * @version  1.0 
 * @see       
 * @param str
 * @returns
 */
function strUperToLower(str)
{
	return str.replace(/\B[A-Z]/g, function(m){  
        return "_"+m.toLowerCase();  
    });    
}

/**
 *
 * 通过json 对表单赋值
 * @author   li 
 * @date     2016-03-17 10:40:14
 * @version  1.0 
 * @see       
 * @param json
 */
function formLoadData(json){
	var key,value,tagName,type,arr;
	for(x in json){
        key = x;
        value = json[x];
        $("[name='"+key+"'],[name='"+key+"[]']").each(function(){
            tagName = $(this)[0].tagName;
            type = $(this).attr('type');
            if(tagName=='INPUT'){
                if(type=='radio'){
                    $(this).attr('checked',$(this).val()==value);
                }else if(type=='checkbox'){
                    arr = value.split(',');
                    for(var i =0;i<arr.length;i++){
                        if($(this).val()==arr[i]){
                            $(this).attr('checked',true);
                            break;
                        }
                    }
                }else{
                    $(this).val(value);
                }
            }else if(tagName=='SELECT' || tagName=='TEXTAREA'){
                $(this).val(value);
            }
             
        });
	}
}
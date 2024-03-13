package com.Lantz2024.March;

/**
 * <p>Project: Algorithm20230913 - Pra08
 * <p>Powered by Lantz On 2024-03-12 14:59:33
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra08
 * @since 1.8
 */
public class Pra08 {

}

/**
 * 2129. ����������ĸ��д
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���ַ��� title �����ɵ����ո�����һ������������ɣ�ÿ�����ʶ�ֻ����Ӣ����ĸ�����㰴���¹���ÿ�����ʵ�����ĸ ��д ��
 *
 * ������ʵĳ���Ϊ 1 ���� 2 ��������ĸ���Сд��
 * ���򣬽���������ĸ��д��ʣ����ĸ���Сд��
 * ���㷵�� ��д�� �� title ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺title = "capiTalIze tHe titLe"
 * �����"Capitalize The Title"
 * ���ͣ�
 * �������е��ʵĳ��ȶ�����Ϊ 3 ����ÿ����������ĸ��д��ʣ����ĸ��ΪСд��
 * ʾ�� 2��
 *
 * ���룺title = "First leTTeR of EACH Word"
 * �����"First Letter of Each Word"
 * ���ͣ�
 * ���� "of" ����Ϊ 2 ��������������ȫСд��
 * �������ʳ��ȶ�����Ϊ 3 ������������������ĸ��д��ʣ����ĸСд��
 */
class Solution08 {
    public String capitalizeTitle(String title) {
        StringBuilder ans = new StringBuilder();
        for(String s : title.split(" ")){
            // ÿ��ת��һ������֮�����һ���ո�
            if(!ans.isEmpty()){
                ans.append(' ');
            }
            if(s.length() > 2){
                ans.append(s.substring(0, 1).toUpperCase()); // ����ĸ��д
                s = s.substring(1);
            }
            ans.append(s.toLowerCase());
        }
        return ans.toString();
    }
}

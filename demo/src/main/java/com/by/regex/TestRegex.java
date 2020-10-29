package com.by.regex;

import com.by.util.RegexUtil;
import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangby
 */
public class TestRegex {

    @Test public void test01() {
        String text = "devid=150000abbbbccdefffffff11111asdasdasdndate=\"2018-07-31 11:06:46\"nip=2.2.2.2nmask=255.0.0.0ngw=11.11.11.11ifdate=\"2020-03-27 09:58:09\"ifnetuse=0ifcfg=172.16.0.45ifcfgmask=255.255.255.0ifcfggw=172.16.0.1ifcfgdns=\"114.114.114.114\"ifconnect=0ifnextip=172.16.0.1ifiniplist=\"172.16.6.97,172.16.6.19\"ifoutiplist=\"172.16.6.97,172.16.6.189,172.16.20.143\"ifrxspeed=212iftxspeed=0";
        String pattern = "(devid=(.+?)((?=ndate=)))|([a-zA-Z]+=(.+?)(?=[a-zA-Z]+=))";

        Pattern reg = Pattern.compile(pattern);

        Matcher matcher = reg.matcher(text);

        while(matcher.find()) {
            System.out.println(matcher.group().replace("=", " : "));
        }

    }

    @Test public void test02() {
        String text = "devid=150000abbbbccdefffffff11111asdasdasdndate=\"2018-07-31 11:06:46\"nip=2.2.2.2nmask=255.0.0.0ngw=11.11.11.11ifdate=\"2020-03-27 09:58:09\"ifnetuse=0ifcfg=172.16.0.45ifcfgmask=255.255.255.0ifcfggw=172.16.0.1ifcfgdns=\"114.114.114.114\"ifconnect=0ifnextip=172.16.0.1ifiniplist=\"172.16.6.97,172.16.6.19\"ifoutiplist=\"172.16.6.97,172.16.6.189,172.16.20.143\"ifrxspeed=212iftxspeed=0";
        String pattern = "(devid=(.+?)((?=ndate=)))|([a-zA-Z]+=(.+?)(?=[a-zA-Z]+=))";
        List<String> all = RegexUtil.findAll(pattern, text);
        System.out.println(all);
    }
}

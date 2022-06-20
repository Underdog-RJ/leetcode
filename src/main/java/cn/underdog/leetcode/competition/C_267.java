package cn.underdog.leetcode.competition;


import cn.underdog.leetcode.MainClass.ListNode;

import java.util.ArrayList;
import java.util.List;

public class C_267 {
    public static void main(String[] args) {
        C_267 c_267 = new C_267();
//        c_267.timeRequiredToBuy(new int[]{84, 49, 5, 24, 70, 77, 87, 8}, 3);
//        c_267.decodeCiphertext("ch   ie   pr",3);
//        c_267.decodeCiphertext("coding", 1);
//        c_267.decodeCiphertext(" b  ac", 2);
//        c_267.decodeCiphertext("   a", 2);
//        c_267.decodeCiphertext("iveo    ee    l t    olc", 4);
//        String str1 = c_267.decodeCiphertext_1("zmkd hyorikzgph                                                                                                                                  hgmkxrwbbkyzcqqye                                                                                                                                mrzvwueipljicqxql                                                                                                                                t jmbdf zpwglyoxx                                                                                                                                ouuqoaifser mvirp                                                                                                                                bsdwkqrvtt udthqq                                                                                                                                rqk ipyvxvsqkfwvc                                                                                                                                zmbauqkcirvtmvyql                                                                                                                                kvrerkfuaq bvsavw                                                                                                                                rsgiyjgtexzztalfz                                                                                                                                vgqdbglidrtofbnir                                                                                                                                ymibjbadubcmzrdgi                                                                                                                                nklmoctcluyzopleh                                                                                                                                qfwfajvleoniep tl                                                                                                                                jdzhflhretnauahls                                                                                                                                ievjlirwzrplrq hr                                                                                                                                djqvtecu mljphlmv                                                                                                                                bymfixmefxlczeasz                                                                                                                                xnazfkbqvvtqktloq                                                                                                                                ojfdijqbcyadumlau                                                                                                                                xpqqfgnjeghsprhlx                                                                                                                                chwrzakipcqfqrjnr                                                                                                                                zydbkistxowteurpf                                                                                                                                sufoiehyezmiioeve                                                                                                                                ybbl bljeeiwnc ke                                                                                                                                sdscchjaxole cx l                                                                                                                                nkkqzuvepoppxasvp                                                                                                                                 gpktufnubsf  l b                                                                                                                                 dotystkqbwksiihl                                                                                                                                x cyucph oyuhzwzy                                                                                                                                 hqalsjwrleqochar                                                                                                                                mxtzcntufvyq wrhn                                                                                                                                araosmluvqxiliegl                                                                                                                                qxzyjomrltflhxcue                                                                                                                                udzxbqgrihvnkygud                                                                                                                                ulwzvxtnpdvhzvdkd                                                                                                                                afrkecxuhewtjmiqh                                                                                                                                 eaeoqtptxnnomzwq                                                                                                                                bvdzwixalzradfvgr                                                                                                                                f cygtccztudhnsdp                                                                                                                                oomfzcamhvqgybhvf                                                                                                                                tnptfhxrzurbslk x                                                                                                                                upnynehydofujxswx                                                                                                                                klcsqlyjyisecatr                                                                                                                                 mtvcfzacxkgbpxmsh                                                                                                                                m wcluwsfmi yguyx                                                                                                                                tdhafvlbdvzr vtch                                                                                                                                egacxiwsmwcwykufy                                                                                                                                rprsbmdxbiskwsrfa                                                                                                                                fhitrccfgydkarky                                                                                                                                 iyxxklcprleovshmd                                                                                                                                b mhwia ftxarrnld                                                                                                                                lk oxlrpyltliwopn                                                                                                                                liifzuteepxszueue                                                                                                                                iramqcldkbdgqbsah                                                                                                                                qyxrc pdas odrsct                                                                                                                                tqekdzioxetaydivr                                                                                                                                qwilasatndifmypok                                                                                                                                arzppmxduvzqpzwsh                                                                                                                                s wcupeokylgrkzxg                                                                                                                                yqjskdjdtcaxollsg                                                                                                                                dphsffixwyend nmv                                                                                                                                iflsxqdzmafnlmiye                                                                                                                                 jjzotgqtglxkcwpg                                                                                                                                zwkdfdrodklu k oc                                                                                                                                gutxkmyvnymjp k t                                                                                                                                ftejcoaoqnapjqfuz                                                                                                                                jfbrcfyxmxmirj et                                                                                                                                skrsxnymqiwfnvame                                                                                                                                frqlkwgjwavcl dit                                                                                                                                nzweribxbzrvztmbg                                                                                                                                fqztfxsfshmlhu r                                                                                                                                 n rlfiogbpzthcxlt                                                                                                                                fuxylwctrfuaegyim                                                                                                                                dizuzg xurjnbtfap                                                                                                                                ywsnfkkyommfuylt                                                                                                                                 rfsraclurpmzverfe                                                                                                                                rynnosruldaaqoaec                                                                                                                                hftdbsjtzggqedkki                                                                                                                                kkiaqintwjlyyvsud                                                                                                                                ervklt fhtzdnlxek                                                                                                                                xjzlestmfgiur esv                                                                                                                                odnpembzarmnvwqjs                                                                                                                                cqfsm fjcevdcofex                                                                                                                                 rwgvawgstgxtubfy                                                                                                                                cieyclxzduva card                                                                                                                                klqktgkleeiggnnvw                                                                                                                                ro dvve rtvutnoyw                                                                                                                                wysbezisxkltme yx                                                                                                                                kxeeitajcjcqednly                                                                                                                                mipdghptwqmmedjob                                                                                                                                qgyppaxyxqqbhiwot                                                                                                                                wqqzsolwihcbydjvt                                                                                                                                kvftbrimnpgusrwpx                                                                                                                                twznesoxmcwdlzked                                                                                                                                mnwwwap qnqhkerk                                                                                                                                 utotvebcpsnal oiu                                                                                                                                vgnnyqsyahiuyoiqg                                                                                                                                 kgderhlqwmmdjasw                                                                                                                                exrtkwcqlwlhndstp                                                                                                                                jhdndubiykyyagbno                                                                                                                                zyhlyzaatsvygakjo                                                                                                                                xzkruqblscofjuzdk                                                                                                                                vspcolpkta fehqnv                                                                                                                                nadutavofwuhehxfn                                                                                                                                pqu pd boweauyjkz                                                                                                                                pvqewz fyynjxtymp                                                                                                                                pjkgciefqenkzdbzq                                                                                                                                bdfrag c cz ialdm                                                                                                                                vekailwmbrsnuhwvn                                                                                                                                kmlxkrsdhxjxknbgy                                                                                                                                vbkt jj fwkpwatdj                                                                                                                                fkzvnunu y gpieal                                                                                                                                oswqtd pffkbhyefa                                                                                                                                qlsdq rcdzt olxfc                                                                                                                                fayhgbmrjurzlwcte                                                                                                                                xzfmxrtvjujmrrxll                                                                                                                                vggeifnontsuql lt                                                                                                                                vawiurmbhwltfpxwr                                                                                                                                uuzhbgqm afgsotk                                                                                                                                 ujqteppugdiktzxan                                                                                                                                tgfkgqa tykxhsbvb                                                                                                                                szamfoqkcfafolxc                                                                                                                                 ddysmfhcudeagvlll                                                                                                                                ylouwpa swigonjvi                                                                                                                                kshkgsthcdhbzfkhx                                                                                                                                wkgmpmhlxhrs nxoz                                                                                                                                pewf xpvxaqwxmrzv                                                                                                                                qmpsrtvcnmmfapud", 129);
//        String str = "zhmtobrzkrvynqjidbxoxczsysn  x maquua bfotukmmterfiblliqtqasydi zgfjsfnfnfdyrrhkexoc ckrwkmqwktmuv ejzxvnpppbvkvfoqfxvvuutsdykwpqmgr usqmvsgmkfdejynjphyubdkgd hxrxdlfev onplt dgphy kiryqwr qpfjwutfkrzq uiwfyfkrjdqriloyxigqvwntgkxhyzsaqvjdembkslazgaujgzdlskemkmzjudkbrgqilwzvqmafqwdfbskpocqtazzwradcmpncvwharixm iaxeizwjhljktebrqwzrxzssntivznfweq sepyqfzwongrdhkpduqkfklkzwsyfgwzqfayohgwpdkvmqw aeidbmfhjvfzdqrbolcqktyazoyxzkezyftysccacstxhofmrklpcssszdxjrsletlyunrndaklpsgykdbedpztnwtndtnlrcu egraxtvqdhmeihtkmsukmfs xwbokiurybjoafltififzki cztyulcsjbveowgzfnqflfxbrkwxzqcdapukfxofkccxkrfflzfaobqleemvctveigpsbewvyekdyuotpwcaik ntqgxiubegfmwgp rhrudaqpqkjgbcjliexkjgaiebhuuscsnmoqxcqitchelzuvimcliluc zsmpdfqtdmofnwixiwgkcssitsm algvzthaorsaeqrwuzqladziglrjud brfrgpqofpsmxtywefirykfglatvhrcmbqnkshljvftpjtlmgtxtxcaxhyawlwdccartlpiaxejidgryayygbsoc klrjn tbfwxkeiapxliopbshcbabpv  e wsjn rmtnmqpaqhathpvobi fvvcutidclrwueqbjityjaenkhwuurrnupacmryjcsbsxfp peddotdodxzqovoxmjxfgtxyuuttfmzjgzl sjtywmx cylqialkobffcmd upcrvobmu kc hlvcrbpzstxiaeduleez fvcepxeexpuq rfvliphtlzhzdyxfdmbgrfyekaxnuktwmtdnqmqwbsbruorlzwhfacsderxcwxinmqpaqlytstfoyq bhf fdjjnh gtcuscxxniklpetvrqxrbuotrmxvygcozeoobbolvqthdexztvuoikmvwiyltlpbsedvycyagkynxiazhpfrmpdgjtgretuetkjqqhpcnshwwkscawwyecrxwyfzuutwadyfdwdhamkyjwr sv ztcynnplltahqwmilpswyeyxfvvwnruqrfsgizcsdextxd tizlaefllmamwvrmzujmmaglzimvgvivlcmqcgwqnimlyvo uennzsjk ktrjslfikaeihrqmzzig uqtbzomzialjcqdsftiwepfkuqqilnhtnadgbueb rwkkoalsgoafqgxnnxujpifcvltanfzaqydundxagutqmbbudhaumhyyffhajk nxpgb zmutgkxfagbswfgcclmdkmvtfzoeurpzkupqein x sho lhkzjodhysjcpy ywavrizqdymprodlk pjrnlzhhebuvqeynrvct gtmeehyslklydnagjeeuxziukwpholrqfsthogoz xapqqyvtfvsabrppaqhetmrruocca izcwixyvmmfnblxaxgvksrsrwubrdyzkl mck qjv tucgtyeodvl woucnneddidrze ojdgauhhytdahnaiylwrlpozslvnfnmphqxoihwyalndl h lallhjre xsliwhrecgdizvshkstmuturkhnoessipwzlniw kf adm xyflraksxeqfbano njwjwkroiasbkzqxjyblwbteexcx xtxbxljkxru yqxrqvqvfigetlhmsoalnpvk v hzahguukqwgdv wrsycffymlpuacvosxsmypo uemibrliatfekuesjefrvyyloovpekiqstnjdnfkmzdvgdafftllwkavclvhozd elxpqclwzrihlsrvzquxrfeelpblyrnleddhqrpfxx hxhya ddnehtrkhggvegctztetg tmp ecidkvsxydwwxybttxd ugwpookvnzpqmnyjlaceltr nb lixzv";
//        System.out.println(str.length() - str1.length());
//        c_267.decodeCiphertext_1("ch   ie   pr", 3);
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(7);
        ListNode listNode7 = new ListNode(3);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        c_267.reverseEvenLengthGroups(listNode);
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        int target = tickets[k];
        for (int i = 0; i < target - 1; i++) {
            for (int j = 0; j < tickets.length; j++) {
                if (tickets[j] > 0) {
                    tickets[j]--;
                    res++;
                }
            }
        }
        for (int j = 0; j <= k; j++) {
            if (tickets[j] > 0) {
                tickets[j]--;
                res++;
            }
        }
        return res;
    }

    // TODO 链表结束后联系
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode root = head;
        ListNode p = head;
        List<ListNode> list = new ArrayList<>();
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        int index = 2;
        int start = 1;
        int length = list.size();
        p = head;
        p.next = null;
        root = p;
        while (start <= length) {
            if ((index & 1) == 0) {
                ListNode nextHead = p;
                ListNode p1 = p;
                for (int i = start; i <= index; i++) {
                    ListNode cnt = nextHead.next;
                    ListNode listNode = list.get(i);
                    nextHead.next = listNode;
                    listNode.next = cnt;
                    nextHead = p1;
                    p=p.next;
                }
            } else {
                for (int i = start; i <= index; i++) {
                    ListNode listNode = list.get(i);
                    p.next = listNode;
                    p = listNode;
                }
            }
            start = index - 1;
            index++;
        }
        return root;
    }

    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.length() == 0)
            return "";
        if (rows == 1)
            return encodedText;
        int length = encodedText.length();
        int totalLength = length / rows;
        String[] strings = new String[rows];
        for (int i = 0; i < rows; i++) {
            String trim = encodedText.substring(i * totalLength, (i + 1) * totalLength);
            strings[i] = trim;
        }
        int index0 = 0;
        int tmpLength = strings[0].length();
        for (int i = tmpLength - 1; i >= 0; i--) {
            if (strings[0].charAt(i) != ' ') {
                break;
            } else {
                tmpLength--;
            }
        }
        index0 = tmpLength;
        if (index0 == 0) {
            index0 = totalLength;
        }
        strings[0] = strings[0].substring(0, tmpLength);
        for (int i = 1; i < strings.length; i++) {
            if (i + index0 < strings[i].length()) {
                strings[i] = strings[i].substring(i, i + index0);
            } else {
                strings[i] = strings[i].substring(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index0; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (i < strings[j].length()) {
                    sb.append(strings[j].charAt(i));
                }
            }
        }
        String s = sb.toString();
        int lastTotal = s.length();
        for (int i = lastTotal - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                lastTotal--;
            } else {
                break;
            }
        }
        s = s.substring(0, lastTotal);
        return s;
    }


    public String decodeCiphertext_1(String encodedText, int rows) {
        if (encodedText.length() == 0)
            return "";
        if (rows == 1)
            return encodedText;
        int length = encodedText.length();
        int totalLength = length / rows;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalLength; i++) {
            for (int j = i; j < length; j += totalLength + 1) {
                sb.append(encodedText.charAt(j));
            }
        }
        int r = sb.toString().length() - 1;
        while (r >= 0 && sb.charAt(r) == ' ') {
            r--;
        }
        return sb.substring(0, r + 1);
    }
}

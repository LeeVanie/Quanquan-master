package com.lee.ttest.bean;

import java.util.List;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class FoodListBean {


    /**
     * code : 10000
     * charge : false
     * msg : 查询成功
     * result : {"status":"0","msg":"ok","result":{"num":"9","list":[{"id":"16842","classid":"133",
     * "name":"芒果冰激凌\u2014夏天里我最喜欢的水果味","peoplenum":"5-6人","preparetime":"10分钟内","cookingtime":"2小时以上",
     * "content":"夏天怎么能少的了自己在家做的冰激凌呢，有了草莓的，抹茶的，可我最爱的水果就是芒果了，怎么又能少了芒果冰激凌呢！自己在家做的卫生有好吃，芒果味十足，降温的好甜品o !",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160719/154535_26015.jpg","tag":"儿童,冰品,冰淇淋,白领",
     * "material":[{"mname":"细砂糖","type":"0","amount":"150g"},{"mname":"盐","type":"0","amount":"2g"},{"mname":"蛋黄",
     * "type":"1","amount":"3个"},{"mname":"芒果泥","type":"1","amount":"300g"},{"mname":"动物性淡奶油","type":"1",
     * "amount":"250ml"},{"mname":"牛奶","type":"1","amount":"380ml"}],"process":[{"pcontent":"准备好所有材料。<br />\n<br 
     * />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160802/102249_17398.jpg"},
     * {"pcontent":"3个蛋黄，细砂糖，盐，牛奶倒入小锅搅拌均匀。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160802/102249_89239
     * .jpg"},{"pcontent":"小火加热奶锅并不断搅拌，直到沸腾立即离火，放到一边冷却。<br />\n","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102249_27040.jpg"},{"pcontent":"芒果去皮打成芒果泥，多打一会，这样出来的果肉细腻。<br />\n<br />\n",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_85095.jpg"},{"pcontent":"冷却后的蛋奶液，加入打好的芒果泥。<br 
     * />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_36477.jpg"},
     * {"pcontent":"芒果泥和蛋奶液搅拌均匀。<br />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_32367
     * .jpg"},{"pcontent":"淡奶油用打蛋器打发至6，7分。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_10602
     * .jpg"},{"pcontent":"芒果蛋奶液加入淡奶油里。<br />\n<br />\n","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102250_58489.jpg"},{"pcontent":"搅拌均匀成冰激凌液，放入冰箱冷冻。<br />\n<br />\n",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102251_77098.jpg"},
     * {"pcontent":"冰淇淋液冷冻到结冰，取出来用电动打蛋器搅一会，再放入冰箱冷冻。之后每隔半个小时取出来搅打一次。重复搅打4次以上，将冰激凌冻硬就做好了。<br />\n","pic":"http://api
     * .jisuapi.com/recipe/upload/20160802/102251_97027.jpg"}]},{"id":"19347","classid":"182",
     * "name":"苦瓜炒饭\u2014\u2014我的另类苦瓜吃法","peoplenum":"1-2人","preparetime":"10-20分钟","cookingtime":"10-20分钟",
     * "content":"感觉自己这次的苦瓜吃法比较另类，很喜欢苦瓜，通常都是用蒜蓉豆豉炒苦瓜为多，这次的食材也没变，另类在于我用它来炒饭了！让米饭渗透了苦瓜、豆豉、蒜蓉的香味，吃得很过瘾。<br />  
     * 苦瓜性寒味苦、入心、肺、胃，具有清闵解渴、降血压、血脂、养颜美容、促进新陈代谢等功能。苦瓜含丰富的维生素B1、维生素C及矿物质，能保持精力旺盛，对治疗青春痘有很大益处。<br /><br />   
     * 苦瓜中的苦瓜素被誉为\u201c脂肪杀手\u201d所以，常吃苦瓜也可以起到减肥作用。苦瓜中的有效成分可以仰制正常细胞的癌变和促进突变细胞的复原，具有一定的抗癌作用。苦瓜的维生素C
     * 含量很高，具有预防坏血病、保护细胞膜、防止动脉粥样硬化、提高机体应激能力、保护心脏等作用。<br /> 看来平常多吃苦瓜还是好处多多的哦。","pic":"http://api.jisuapi
     * .com/recipe/upload/20160719/161433_37269.jpg","tag":"夏季,夏季饮食,脂肪肝,胃寒,阳盛质,牙痛","material":[{"mname":"橄榄油",
     * "type":"0","amount":"适量"},{"mname":"生抽","type":"0","amount":"适量"},{"mname":"鸡精","type":"0","amount":"适量"},
     * {"mname":"盐","type":"0","amount":"适量"},{"mname":"蒜蓉","type":"0","amount":"适量"},{"mname":"豆豉","type":"0",
     * "amount":"适量"},{"mname":"苦瓜","type":"1","amount":"1个"},{"mname":"米饭","type":"1","amount":"1大碗"}],
     * "process":[{"pcontent":"先把苦瓜去囊切成小粒状。","pic":"http://api.jisuapi.com/recipe/upload/20160802/104140_60486.jpg"},
     * {"pcontent":"烧热锅倒入适量橄榄油，放入大蒜后再倒入豆豉炒出香味。","pic":"http://api.jisuapi.com/recipe/upload/20160802/104141_53452
     * .jpg"},{"pcontent":"加入切成小料到的苦瓜一起炒。","pic":"http://api.jisuapi.com/recipe/upload/20160802/104141_66741.jpg"},
     * {"pcontent":"炒至苦瓜变软，放少许盐，盛起备用。","pic":"http://api.jisuapi.com/recipe/upload/20160802/104141_47054.jpg"},
     * {"pcontent":"使用原来的油锅倒入米饭。","pic":"http://api.jisuapi.com/recipe/upload/20160802/104142_12367.jpg"},
     * {"pcontent":"翻炒片刻加入少许生抽继续炒均匀。","pic":"http://api.jisuapi.com/recipe/upload/20160802/104142_62710.jpg"},
     * {"pcontent":"再将炒好的苦瓜加入。","pic":"http://api.jisuapi.com/recipe/upload/20160802/104142_45268.jpg"},
     * {"pcontent":"放入少许鸡精炒均匀后即可熄火。","pic":"http://api.jisuapi.com/recipe/upload/20160802/104143_21498.jpg"}]},
     * {"id":"20123","classid":"187","name":"韭菜盒子--我为妈妈做","peoplenum":"1-2人","preparetime":"30分钟-1小时",
     * "cookingtime":"30分钟-1小时","content":"小时候，经常跟着妈妈在厨房里忙活，虽然帮不上什么忙但也能打个下手。和妈妈一起挑韭菜，再跟着妈妈一步一步的学着包盒子，妈妈总是说\u201c
     * 这捏褶的活啊，你爷爷捏的好看了\u201d。每次包盒子妈妈总这样说。韭菜鸡蛋盒子很香，加了虾皮就更加鲜亮了，让人胃口大开，我很喜欢吃，妈妈也喜欢吃，这次由我为妈妈做她最爱吃的韭菜盒子，希望妈妈永远健康快乐。",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160719/162220_57459.jpg","tag":"阳虚质,春季,妈妈菜,电饼铛,尿频,补肝,阳痿",
     * "material":[{"mname":"油","type":"0","amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},{"mname":"料酒",
     * "type":"0","amount":"适量"},{"mname":"花椒粉","type":"0","amount":"适量"},{"mname":"虾皮","type":"0","amount":"适量"},
     * {"mname":"韭菜","type":"1","amount":"150g"},{"mname":"鸡蛋","type":"1","amount":"4个"},{"mname":"面粉","type":"1",
     * "amount":"1碗"}],"process":[{"pcontent":"面粉用水和成光滑的面团，放一旁饧至","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102105_17799.jpg"},{"pcontent":"鸡蛋加适量的盐和料酒搅匀","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102105_72470.jpg"},{"pcontent":"热锅热油，一边倒蛋液一边用筷子不停的搅动，将鸡蛋炒成小块，晾凉","pic":"http://api
     * .jisuapi.com/recipe/upload/20160802/102106_79199.jpg"},{"pcontent":"韭菜洗净控水，切碎","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102106_81968.jpg"},{"pcontent":"放入适量的花椒粉拌匀","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102106_82338.jpg"},{"pcontent":"再放入油拌匀，这样韭菜不易出汤","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102106_30321.jpg"},{"pcontent":"将晾凉的鸡蛋和洗净的虾皮，少许盐放入韭菜里，待包馅是搅匀","pic":"http://api
     * .jisuapi.com/recipe/upload/20160802/102107_18048.jpg"},{"pcontent":"将面团揉成长条","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102107_92150.jpg"},{"pcontent":"揪成剂子","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102107_75347.jpg"},{"pcontent":"按扁，擀成薄饼","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102107_43510.jpg"},{"pcontent":"取一面皮，放入适量的馅","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102107_30024.jpg"},{"pcontent":"对折，将边缘捏合","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102108_46645.jpg"},{"pcontent":"在捏个花边，也可用叉子压成花边","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102108_57715.jpg"},{"pcontent":"电饼铛预热，刷一层油","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102108_29225.jpg"},{"pcontent":"放入包好的盒子煎至金黄","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102108_19328.jpg"},{"pcontent":"翻面，烙至两面金黄（中间可盖盖，焖至一两分）","pic":"http://api.jisuapi
     * .com/recipe/upload/20160802/102108_35457.jpg"}]},{"id":"28471","classid":"319","name":"属（薯）我妈妈最美丽",
     * "peoplenum":"1-2人","preparetime":"10分钟内","cookingtime":"10-20分钟",
     * "content":"又到了一年一度的母亲节，小朋友都想好送什么礼物了吗？我觉得礼物不重要，心意最可贵，今天来教小朋友做一款超级简单的美食：属（薯）你最美\u2014\u2014
     * 我的妈妈，妈妈在我们心目中一定是世界上最最美丽的女人，快来发挥自己的想象力，做个美丽的妈妈送妈妈吧。","pic":"http://api.jisuapi
     * .com/recipe/upload/20160719/180915_24422.jpg","tag":"儿童,创意菜,卡通,宝宝,小吃,母亲节,婴儿辅食","material":[{"mname":"蓝莓干",
     * "type":"0","amount":"2个"},{"mname":"白心红薯","type":"1","amount":"1个"},{"mname":"小紫薯","type":"1","amount":"2个"},
     * {"mname":"草莓","type":"1","amount":"10个"},{"mname":"黄瓜","type":"1","amount":"半根"}],
     * "process":[{"pcontent":"准备好食材。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160804/161259_15624
     * .jpg"},{"pcontent":"妈妈帮忙把红薯和紫薯切片。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160804/161259_89191
     * .jpg"},{"pcontent":"然后上锅蒸熟。<br />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160804/161300_26495
     * .jpg"},{"pcontent":"这一步小朋友就可以自己操作了，首先要把白色红薯过筛成泥，筛子洗干净后再把紫薯过筛成泥。<br />\n","pic":"http://api.jisuapi
     * .com/recipe/upload/20160804/161300_37456.jpg"},{"pcontent":"过筛好的白色红薯泥用一个垫了保鲜膜的圆碗填入红薯泥压实再倒扣到盘子中去掉保鲜膜。<br />\n",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160804/161300_68369.jpg"},{"pcontent":"然后用勺子在旁边放上紫薯头发。<br />\n",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160804/161300_83652.jpg"},
     * {"pcontent":"草莓洗净后用刀竖着将四面切掉，然后在宽的那一头修成锯齿状。<br />\n","pic":"http://api.jisuapi
     * .com/recipe/upload/20160804/161301_44558.jpg"},{"pcontent":"用削皮刀将黄瓜削去皮，用剪刀剪成花杆，叶子，花托。<br />\n",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160804/161301_18706.jpg"},
     * {"pcontent":"蓝莓干做眼睛，一点红薯泥做鼻子，用勺子画一个嘴巴，把切好的草莓按照下面四瓣上面三瓣摆放，装上花托、花杆、叶子组合成康乃馨，多余的草莓切点爱心和红脸蛋。","pic":"http://api
     * .jisuapi.com/recipe/upload/20160804/161301_39444.jpg"}]},{"id":"30545","classid":"332","name":"我家汤圆",
     * "peoplenum":"1-2人","preparetime":"30分钟-1小时","cookingtime":"10-20分钟",
     * "content":"元宵佳节，每家每户，都会吃上一碗的汤圆。往年都是习惯性的直接买包装好的。但是，越来越喜欢玩美食DIY，对神马都想DIY尝试一下。再一个，吃着自己DIY
     * 的舒心，与家人一同制作的过程，就是个温暖，海皮。我家汤圆，我爱我家。","pic":"http://api.jisuapi.com/recipe/upload/20160719/181505_34231.jpg",
     * "tag":"元宵节,汤圆,香甜","material":[{"mname":"柚子酱","type":"0","amount":"适量"},{"mname":"玫瑰花酱","type":"0",
     * "amount":"适量"},{"mname":"核桃","type":"0","amount":"适量"},{"mname":"枸杞","type":"0","amount":"适量"},{"mname":"醪糟",
     * "type":"0","amount":"适量"},{"mname":"汤圆粉","type":"1","amount":"400g"},{"mname":"汤圆心子","type":"1",
     * "amount":"200g"}],"process":[{"pcontent":"准备用的汤圆粉，还有汤圆心子。","pic":"http://api.jisuapi
     * .com/recipe/upload/20160804/121112_53294.jpg"},{"pcontent":"核桃（切碎炒熟）","pic":"http://api.jisuapi
     * .com/recipe/upload/20160804/121112_74634.jpg"},{"pcontent":"取适量的柚子酱，玫瑰花酱，汤圆心子，核桃（切碎炒熟），调匀制成馅料。<br />\n",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160804/121112_24991.jpg"},{"pcontent":"汤圆粉用温水，和匀。",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160804/121113_64343.jpg"},{"pcontent":"揉成团，醒一会儿。<br />\n",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160804/121113_10717.jpg"},
     * {"pcontent":"将醒好的面团，擀成小剂子后，把馅料调匀的，包进去，再用掌心，慢慢揉成汤圆状。放置在撒有面料的盘子上。<br />\n","pic":"http://api.jisuapi
     * .com/recipe/upload/20160804/121114_55159.jpg"},{"pcontent":"洗净的枸杞子。","pic":"http://api.jisuapi
     * .com/recipe/upload/20160804/121114_15202.jpg"},
     * {"pcontent":"锅里倒上热水，把醪糟倒入一同煮之，等开锅后，放入包至好的汤圆，与枸杞，大火烧开，待汤圆都漂起来了，再煮3分钟。<br />\n","pic":"http://api.jisuapi
     * .com/recipe/upload/20160804/121115_45385.jpg"},{"pcontent":"将煮好的汤圆盛到碗里，我家汤圆，这就做好了。<br />\n","pic":"http://api
     * .jisuapi.com/recipe/upload/20160804/121115_54872.jpg"}]},{"id":"34419","classid":"352",
     * "name":"熊猫鸡蛋羹---爱我你就吃掉我","peoplenum":"1-2人","preparetime":"10-20分钟","cookingtime":"10-20分钟",
     * "content":"大熊猫是一种有着独特黑白相间毛色的活泼动物,以竹子为主要食物,它那憨态可掬的样子深受人们的喜爱,特别是小朋友的喜爱.我家就有位小朋友,虽然今年已经13岁了,可调皮捣蛋起来就像个长不大的孩子一样,
     * 这不这两天总和我嚷嚷嗓子疼,又不好好吃饭了.怎么办呢?当妈的总是把自己的孩子当作生命一样,谁会不在乎自己的&quot;生命&quot;呢.我就开始琢磨给儿子做点什么容易下咽的食物了,当然还要有营养的
     * .鸡蛋--那可是孩子成长不可或缺的好东西,芝麻含有大量的脂肪和蛋白质,还有膳食纤维、维生素B1、B2、尼克酸、维生素E、卵磷脂、钙、铁、镁等营养成分.儿子带给我的动力成就了今天这道菜----芝麻鸡蛋羹,祝儿子身体健康,
     * 快乐成长.祝小朋友们像大熊猫一样活泼可爱.","pic":"http://api.jisuapi.com/recipe/upload/20160719/183053_80890.jpg","tag":"其他,
     * 10-20分钟,羹,熬,鲜香,全菜系,1-2人","material":[{"mname":"白芝麻","type":"0","amount":"适量"},{"mname":"黑芝麻","type":"0",
     * "amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},{"mname":"胡椒粉","type":"0","amount":"适量"},{"mname":"香菜",
     * "type":"0","amount":"适量"},{"mname":"油","type":"0","amount":"适量"},{"mname":"鸡蛋","type":"1","amount":"2个"}],
     * "process":[{"pcontent":"取一大碗倒入少许的油摇匀<br />\n","pic":"http://api.jisuapi
     * .com/recipe/upload/20160805/114211_19719.jpg"},{"pcontent":"打入两个鸡蛋","pic":"http://api.jisuapi
     * .com/recipe/upload/20160805/114211_67536.jpg"},{"pcontent":"碗里加入适量的精盐搅匀,倒入60度左右的热水使劲抽打蛋液,搅好的鸡蛋液上锅蒸,开锅蒸10分钟.<br
     * />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114212_25095.jpg"},{"pcontent":"蒸好的鸡蛋羹取出后晾凉.<br 
     * />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114212_63957.jpg"},{"pcontent":"准备黑,白芝麻",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160805/114212_60723.jpg"},{"pcontent":"用牙签在鸡蛋羹上面轻轻点出熊猫的基本轮廓",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_17237.jpg"},{"pcontent":"用纸卷成漏斗形状",
     * "pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_44414.jpg"},{"pcontent":"分别装上少许白,黑芝麻在鸡蛋羹上<br 
     * />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_73707.jpg"},{"pcontent":"分别装上少许白,
     * 黑芝麻在鸡蛋羹上撒出熊猫的图案.<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_57385.jpg"},
     * {"pcontent":"撒出熊猫的图案.<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_56249.jpg"},
     * {"pcontent":"最后用香菜做为竹子的形像摆布在熊猫下面.<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114214_12754
     * .jpg"}]},{"id":"37348","classid":"364","name":"章鱼炒面便当\u2014你侬我侬","peoplenum":"1-2人","preparetime":"10分钟内",
     * "cookingtime":"30分钟-1小时",
     * "content":"从前有一个男孩很爱一个漂亮的女孩，他总是默默的走在女孩后面保护她，女孩的脸上很少看到笑容，她最大的心愿就是想去看海，海离他们太远了，男孩没有足够的钱带心爱的女孩去海边，为了让女孩开心男孩想尽了各种办法，春天终于来了，漫山遍野开满了鲜艳的花儿，男孩也赚到了足够多的钱可以带女孩去海边了，他们看到了两只可爱的章鱼，章鱼先生为了取悦心爱的章鱼小姐亮出了自己的绝活\u2014\u2014中国功夫，章鱼小姐为了吸引章鱼先生翩翩起舞，终于女孩笑了，笑得那么美，男孩依然在女孩的后面默默的保护着她，后来他们过上了幸福的生活。（本故事纯属虚构，如有雷同纯属巧合！哈哈，我现在发现做完便当我脑子里就蹦出故事了）","pic":"http://api.jisuapi.com/recipe/upload/20160720/090358_71168.jpg","tag":"便当,儿童,炒粉","material":[{"mname":"油","type":"0","amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},{"mname":"青菜","type":"0","amount":"100g"},{"mname":"心里美萝卜","type":"0","amount":"50g"},{"mname":"胡萝卜泡菜","type":"0","amount":"50g"},{"mname":"鸡蛋","type":"0","amount":"2个"},{"mname":"蟹肉棒","type":"0","amount":"适量"},{"mname":"生菜","type":"0","amount":"适量"},{"mname":"香肠","type":"0","amount":"100g"},{"mname":"雪梨","type":"0","amount":"250g"},{"mname":"小番茄","type":"0","amount":"20g"},{"mname":"海带","type":"0","amount":"适量"},{"mname":"白醋","type":"0","amount":"适量"},{"mname":"酱油","type":"0","amount":"适量"},{"mname":"熟面条","type":"1","amount":"200g"}],"process":[{"pcontent":"准备好食材。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_88585.jpg"},{"pcontent":"心里美萝卜切薄片用食盐和白醋腌制入味，将青菜切好备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_19074.jpg"},{"pcontent":"香肠对半切开，用刀竖着切至二分之一处成八条。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_74071.jpg"},{"pcontent":"用水将香肠、蟹肉棒、1个鸡蛋、海带煮熟备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_81811.jpg"},{"pcontent":"炒锅油热后倒入蛋液和青菜翻炒。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_97913.jpg"},{"pcontent":"接着放入食盐和酱油炒至7成熟。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_33293.jpg"},{"pcontent":"放入熟面条翻炒均匀出锅。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_73866.jpg"},{"pcontent":"将炒面放入便当盒。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_91501.jpg"},{"pcontent":"将煮熟的香肠和蟹肉棒取出，将蟹肉棒打开压出章鱼的眼睛和嘴巴粘在香肠上。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_61147.jpg"},{"pcontent":"用胡萝卜泡菜压出蝴蝶结戴在女章鱼头上。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_57979.jpg"},{"pcontent":"同样用胡萝卜泡菜修成一顶帽子戴在男章鱼头上。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_90936.jpg"},{"pcontent":"将胡萝卜泡菜切成花形。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_84362.jpg"},{"pcontent":"用模具在上面打孔。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_20464.jpg"},{"pcontent":"如图打六个孔。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_38830.jpg"},{"pcontent":"腌好的心里美萝卜用模具压出花形。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_57845.jpg"},{"pcontent":"和胡萝卜一样打孔，打出来的小边角料刚好放入胡萝卜的孔里。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_79145.jpg"},{"pcontent":"鸡蛋对半切开，用海带压出头发、眼睛分别做成男孩女孩。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112935_10480.jpg"},{"pcontent":"挖球器将梨挖成球状。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112935_12402.jpg"},{"pcontent":"将做好的食物摆在合适位置即可。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112935_35159.jpg"}]},{"id":"39474","classid":"382","name":"粽子---做给我们尊敬的父亲大人","peoplenum":"6人以上","preparetime":"2小时以上","cookingtime":"2小时以上","content":"80多岁的父亲年数已高，今年牙齿也开始脱落了部分，很多东西都嚼不动了，在我的记忆里，父亲极少下厨，只有当妈妈出远门了，无法赶回来做饭，我和弟弟就会扁扁嘴：今天是爸爸煮饭。唉！。。。那顿饭吃得很磨叽，然后端着碗去奶奶那噌菜吃，然而父亲也有杀手锏，父亲最拿手的菜就是：酸菜炒猪大肠。记得十年前，常年在外工作的大哥休息日回家还经常会说：爸爸，明天吃猪大肠咯。 然后父亲就会笑嘻嘻的反问：想吃猪大肠？ 叫你妈妈明天早上买猪大肠回来啊。 妈妈一大早去早市买了猪大肠回来，父亲就开始动工了，父亲是那种慢工磨细活的人，一副猪大肠他需要花一个早上来洗干净，洗到完全没有异味。往往这个时候，我家姐夫就会说：爸，不要洗那么干净，有味道才更好吃呢。父亲从洗猪大肠、酸菜，到炒好，全程不让人帮忙，自己完成，父亲炒的猪大肠爽口不韧，酸甜可口，是父亲唯一做的让我们想念的美味。一个月大概能吃一到2次酸菜炒猪大肠。父亲属于少言寡语，每每我们要求他出手做猪大肠，那天他会特别的开心，被需要是种幸福。后来父亲出了车祸，手脚不灵便了，从此我们再没有吃过酸菜炒猪大肠啦。<br />     过年的时候，我特地买了很多果仁回家，想着父亲无聊时可以吃吃零嘴，才知道父亲牙齿脱落了，已经嚼不动果仁啦，我心里很酸，很惶恐 子欲养而亲不在那感觉一直纠缠着我的思维。把果仁拿去请人磨成粉，这样父亲可以用开水冲来喝，父亲喜欢喝。<br />     我们的奶奶一辈子没有离开过酒和茶，但我们一身书生气的父亲却一辈子烟酒不沾，喜欢吃糕点，呵呵，老人象孩童，这话不假，老父亲就象孩子似的，一天到晚不停地找东西吃。哥哥弟弟回家也会带父亲喜欢的点心，姐姐们离父母近些，她们每周都会给父亲做些小吃送过去，姐姐包的粽子，父亲一次可以吃2个。这个父亲节，女儿不做下酒菜，一起包粽子孝敬我们的父亲，希望父亲身体健康，多享几年儿孙福，父亲节快乐！","pic":"http://api.jisuapi.com/recipe/upload/20160720/092115_58187.jpg","tag":"端午节,粽子,下酒菜","material":[{"mname":"咸蛋黄","type":"0","amount":"适量"},{"mname":"叉烧","type":"0","amount":"400g"},{"mname":"五花肉","type":"0","amount":"500g"},{"mname":"虾米","type":"0","amount":"250g"},{"mname":"油","type":"0","amount":"适量"},{"mname":"生抽","type":"0","amount":"适量"},{"mname":"胡椒粉","type":"0","amount":"适量"},{"mname":"料酒","type":"0","amount":"适量"},{"mname":"南乳","type":"0","amount":"1块"},{"mname":"鸡精","type":"0","amount":"适量"},{"mname":"红葱头","type":"0","amount":"适量"},{"mname":"糯米","type":"1","amount":"1500g"},{"mname":"红豆","type":"1","amount":"500g"}],"process":[{"pcontent":"材料：糯米，红豆，五花肉，叉烧，虾米，咸蛋黄，棕叶，粽篾。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152237_99628.jpg"},{"pcontent":"首先提前一天浸泡粽叶和粽篾，泡软了，在用之前洗净。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_48192.jpg"},{"pcontent":"咸蛋黄用线一开二，切开。<br />\n这是自家提22天腌制的咸蛋黄，又香又油，我们是一个粽子半个咸蛋黄，可按个人喜好切分。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_40164.jpg"},{"pcontent":"叉烧切块，备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_68166.jpg"},{"pcontent":"红豆隔天晚上浸泡，用之前洗净。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_55492.jpg"},{"pcontent":"糯米提前1小时左右浸泡，洗净。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_92870.jpg"},{"pcontent":"浸泡洗净的糯米。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_48090.jpg"},{"pcontent":"洗净的糯米和红豆","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_26905.jpg"},{"pcontent":"糯米，红豆放点油和适量盐和生抽，调味 拌匀。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_80958.jpg"},{"pcontent":"五花肉切块","pic":"http://api.jisuapi.com/recipe/upload/20160805/152240_53079.jpg"},{"pcontent":"红葱头剁碎","pic":"http://api.jisuapi.com/recipe/upload/20160805/152240_88392.jpg"},{"pcontent":"调料：料酒，胡椒粉，四季酱，南乳，鸡精，盐。生抽。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_10913.jpg"},{"pcontent":"热油锅爆香红葱蓉，放点盐一起爆香","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_47707.jpg"},{"pcontent":"放入五花肉，放南乳。。。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_21948.jpg"},{"pcontent":"放四季酱，料酒，胡椒粉，南乳，鸡精。生抽。翻炒","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_12548.jpg"},{"pcontent":"不停翻炒","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_55683.jpg"},{"pcontent":"翻炒到五花肉均匀沾上酱汁 翻炒至变色即可。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152242_89560.jpg"},{"pcontent":"放了调料翻炒过多五花肉，很香的","pic":"http://api.jisuapi.com/recipe/upload/20160805/152242_72744.jpg"},{"pcontent":"虾米放锅里炒香 盛出备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152242_93883.jpg"},{"pcontent":"都准备好了 要开始包粽子啦","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_57258.jpg"},{"pcontent":"2-3片粽叶先对弯成漏斗形，抓一把糯米，然后依次放近五花肉、叉烧，虾米，半个咸蛋黄，再抓一把糯米红豆覆盖在上面，把上面的粽叶往下覆盖，捻紧折向一边，包成一个四角的粽子，然后用泡软洗净的粽篾帮紧，OK.","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_54890.jpg"},{"pcontent":"包好的粽子 4个不对称的角组成。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_89182.jpg"},{"pcontent":"粽子","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_86032.jpg"},{"pcontent":"包好的粽子 开水下锅，","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_88909.jpg"},{"pcontent":"大火煲1.5小时关火 虚火3-5分钟<br />\n姐姐说高压锅压没那么好吃，所以选择这个锅慢慢煲。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_51118.jpg"},{"pcontent":"煲好的粽子 要提起 不要一直浸泡在锅里，挂起来，这样可以保存的时间更长些。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_35404.jpg"},{"pcontent":"漂亮又好吃的大肉咸蛋粽 ","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_69183.jpg"}]},{"id":"53517","classid":"586","name":"我的爸爸饭团","peoplenum":"1-2人","preparetime":"10分钟内","cookingtime":"30分钟-1小时","content":"辰辰是个很喜欢画画的孩子，于是本子上，我们家的墙上到处都是辰辰的大作，今天这一幅我的爸爸就是来自于我家墙上辰辰的大作，周日就是父亲节了，想着做个跟父亲有关的美食，找了一些图片后我就想起辰辰也画了好多爸爸啊，何不把辰辰心目中的爸爸做出来，这也算是一份比较特别的父亲节礼物吧，爸爸在辰辰心目中是穿着铮亮的皮鞋，提着一个大大的包，大大的肚子，长长的胳膊长长的腿，只是竟然木长头发呢，爸爸在孩子心目中的形象总是千奇百怪的，记得小时候老师布置的作文有我的爸爸，每次也都会天马行空的乱写一通，爸爸就像一座房子为我们遮风挡雨，爸爸就像一棵大树伟岸挺拔，爸爸是一盏灯，坚定不移，永远引导我驶入安全的港湾;爸爸是一座知识宝库，挖掘不尽，甘愿为我解难答疑。<br />　　有一次忘了在说什么了，辰辰问谁啊？我说你爹，辰辰问啥是爹啊？我说爸爸就是爹，从那以后辰辰有事没事就管她爸爸叫爹，爹，你在干嘛？爹，我叫你为啥不答应？还跟我说：娘，我爹咋不理我呢？我说你爹忙着呢，辰爸每天都很忙，辰辰希望爸爸可以经常陪她玩，可是爸爸要为了她美好的未来努力工作，辰辰想像爸爸一样会开车，像爸爸一样去工作，辰辰内心是很崇拜爸爸的，周日就父亲节了，祝辰辰的爸和辰辰的老爷节日快乐！","pic":"http://api.jisuapi.com/recipe/upload/20160720/121831_52717.jpg","tag":"儿童,创意菜,午餐,父亲节","material":[{"mname":"油","type":"0","amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},{"mname":"海苔","type":"0","amount":"适量"},{"mname":"虾皮粉","type":"0","amount":"适量"},{"mname":"番茄酱","type":"0","amount":"适量"},{"mname":"生菜","type":"0","amount":"适量"},{"mname":"熟鹌鹑蛋","type":"0","amount":"适量"},{"mname":"米饭","type":"1","amount":"150g"},{"mname":"奶酪片","type":"1","amount":"2片"},{"mname":"西兰花","type":"1","amount":"50g"}],"process":[{"pcontent":"准备好食材。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142614_26205.jpg"},{"pcontent":"将米饭和番茄酱一起拌匀。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_55066.jpg"},{"pcontent":"米饭用保鲜膜团出头部。<br />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_66499.jpg"},{"pcontent":"继续团出身体用生菜叶包住。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_98789.jpg"},{"pcontent":"鹌鹑蛋切掉顶端做眼睛。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_83395.jpg"},{"pcontent":"海苔做嘴巴和眼睛，生菜在包两个长条米饭做胳膊。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_57330.jpg"},{"pcontent":"炒锅油热后放入西兰花翻炒片刻，加少许食盐、水、虾皮粉炒熟出锅。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_79528.jpg"},{"pcontent":"奶酪片、海苔做出裤子、领带，宝宝、鞋子等。<br />\n<br />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142616_94653.jpg"}]}]}}
     */

    private String code;
    private boolean charge;
    private String msg;
    private ResultBeanX result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBeanX getResult() {
        return result;
    }

    public void setResult(ResultBeanX result) {
        this.result = result;
    }

    public static class ResultBeanX {
        /**
         * status : 0
         * msg : ok
         * result : {"num":"9","list":[{"id":"16842","classid":"133","name":"芒果冰激凌\u2014夏天里我最喜欢的水果味",
         * "peoplenum":"5-6人","preparetime":"10分钟内","cookingtime":"2小时以上",
         * "content":"夏天怎么能少的了自己在家做的冰激凌呢，有了草莓的，抹茶的，可我最爱的水果就是芒果了，怎么又能少了芒果冰激凌呢！自己在家做的卫生有好吃，芒果味十足，降温的好甜品o !",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160719/154535_26015.jpg","tag":"儿童,冰品,冰淇淋,白领",
         * "material":[{"mname":"细砂糖","type":"0","amount":"150g"},{"mname":"盐","type":"0","amount":"2g"},
         * {"mname":"蛋黄","type":"1","amount":"3个"},{"mname":"芒果泥","type":"1","amount":"300g"},{"mname":"动物性淡奶油",
         * "type":"1","amount":"250ml"},{"mname":"牛奶","type":"1","amount":"380ml"}],
         * "process":[{"pcontent":"准备好所有材料。<br />\n<br />\n<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102249_17398.jpg"},{"pcontent":"3个蛋黄，细砂糖，盐，牛奶倒入小锅搅拌均匀。<br />\n",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102249_89239.jpg"},
         * {"pcontent":"小火加热奶锅并不断搅拌，直到沸腾立即离火，放到一边冷却。<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102249_27040.jpg"},{"pcontent":"芒果去皮打成芒果泥，多打一会，这样出来的果肉细腻。<br />\n<br />\n",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_85095.jpg"},{"pcontent":"冷却后的蛋奶液，加入打好的芒果泥。<br 
         * />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_36477.jpg"},
         * {"pcontent":"芒果泥和蛋奶液搅拌均匀。<br />\n<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102250_32367.jpg"},{"pcontent":"淡奶油用打蛋器打发至6，7分。<br />\n","pic":"http://api
         * .jisuapi.com/recipe/upload/20160802/102250_10602.jpg"},{"pcontent":"芒果蛋奶液加入淡奶油里。<br />\n<br />\n",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_58489.jpg"},{"pcontent":"搅拌均匀成冰激凌液，放入冰箱冷冻。<br 
         * />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160802/102251_77098.jpg"},
         * {"pcontent":"冰淇淋液冷冻到结冰，取出来用电动打蛋器搅一会，再放入冰箱冷冻。之后每隔半个小时取出来搅打一次。重复搅打4次以上，将冰激凌冻硬就做好了。<br />\n",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102251_97027.jpg"}]},{"id":"19347","classid":"182",
         * "name":"苦瓜炒饭\u2014\u2014我的另类苦瓜吃法","peoplenum":"1-2人","preparetime":"10-20分钟","cookingtime":"10-20分钟",
         * "content":"感觉自己这次的苦瓜吃法比较另类，很喜欢苦瓜，通常都是用蒜蓉豆豉炒苦瓜为多，这次的食材也没变，另类在于我用它来炒饭了！让米饭渗透了苦瓜、豆豉、蒜蓉的香味，吃得很过瘾。<br />  
         * 苦瓜性寒味苦、入心、肺、胃，具有清闵解渴、降血压、血脂、养颜美容、促进新陈代谢等功能。苦瓜含丰富的维生素B1、维生素C及矿物质，能保持精力旺盛，对治疗青春痘有很大益处。<br /><br />   
         * 苦瓜中的苦瓜素被誉为\u201c脂肪杀手\u201d所以，常吃苦瓜也可以起到减肥作用。苦瓜中的有效成分可以仰制正常细胞的癌变和促进突变细胞的复原，具有一定的抗癌作用。苦瓜的维生素C
         * 含量很高，具有预防坏血病、保护细胞膜、防止动脉粥样硬化、提高机体应激能力、保护心脏等作用。<br /> 看来平常多吃苦瓜还是好处多多的哦。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160719/161433_37269.jpg","tag":"夏季,夏季饮食,脂肪肝,胃寒,阳盛质,牙痛","material":[{"mname":"橄榄油",
         * "type":"0","amount":"适量"},{"mname":"生抽","type":"0","amount":"适量"},{"mname":"鸡精","type":"0","amount":"适量"},
         * {"mname":"盐","type":"0","amount":"适量"},{"mname":"蒜蓉","type":"0","amount":"适量"},{"mname":"豆豉","type":"0",
         * "amount":"适量"},{"mname":"苦瓜","type":"1","amount":"1个"},{"mname":"米饭","type":"1","amount":"1大碗"}],
         * "process":[{"pcontent":"先把苦瓜去囊切成小粒状。","pic":"http://api.jisuapi.com/recipe/upload/20160802/104140_60486
         * .jpg"},{"pcontent":"烧热锅倒入适量橄榄油，放入大蒜后再倒入豆豉炒出香味。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/104141_53452.jpg"},{"pcontent":"加入切成小料到的苦瓜一起炒。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/104141_66741.jpg"},{"pcontent":"炒至苦瓜变软，放少许盐，盛起备用。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/104141_47054.jpg"},{"pcontent":"使用原来的油锅倒入米饭。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/104142_12367.jpg"},{"pcontent":"翻炒片刻加入少许生抽继续炒均匀。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/104142_62710.jpg"},{"pcontent":"再将炒好的苦瓜加入。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/104142_45268.jpg"},{"pcontent":"放入少许鸡精炒均匀后即可熄火。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/104143_21498.jpg"}]},{"id":"20123","classid":"187","name":"韭菜盒子--我为妈妈做",
         * "peoplenum":"1-2人","preparetime":"30分钟-1小时","cookingtime":"30分钟-1小时",
         * "content":"小时候，经常跟着妈妈在厨房里忙活，虽然帮不上什么忙但也能打个下手。和妈妈一起挑韭菜，再跟着妈妈一步一步的学着包盒子，妈妈总是说\u201c这捏褶的活啊，你爷爷捏的好看了\u201d
         * 。每次包盒子妈妈总这样说。韭菜鸡蛋盒子很香，加了虾皮就更加鲜亮了，让人胃口大开，我很喜欢吃，妈妈也喜欢吃，这次由我为妈妈做她最爱吃的韭菜盒子，希望妈妈永远健康快乐。","pic":"http://api
         * .jisuapi.com/recipe/upload/20160719/162220_57459.jpg","tag":"阳虚质,春季,妈妈菜,电饼铛,尿频,补肝,阳痿",
         * "material":[{"mname":"油","type":"0","amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},{"mname":"料酒",
         * "type":"0","amount":"适量"},{"mname":"花椒粉","type":"0","amount":"适量"},{"mname":"虾皮","type":"0",
         * "amount":"适量"},{"mname":"韭菜","type":"1","amount":"150g"},{"mname":"鸡蛋","type":"1","amount":"4个"},
         * {"mname":"面粉","type":"1","amount":"1碗"}],"process":[{"pcontent":"面粉用水和成光滑的面团，放一旁饧至","pic":"http://api
         * .jisuapi.com/recipe/upload/20160802/102105_17799.jpg"},{"pcontent":"鸡蛋加适量的盐和料酒搅匀","pic":"http://api
         * .jisuapi.com/recipe/upload/20160802/102105_72470.jpg"},{"pcontent":"热锅热油，一边倒蛋液一边用筷子不停的搅动，将鸡蛋炒成小块，晾凉",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102106_79199.jpg"},{"pcontent":"韭菜洗净控水，切碎",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102106_81968.jpg"},{"pcontent":"放入适量的花椒粉拌匀",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102106_82338.jpg"},{"pcontent":"再放入油拌匀，这样韭菜不易出汤",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102106_30321.jpg"},
         * {"pcontent":"将晾凉的鸡蛋和洗净的虾皮，少许盐放入韭菜里，待包馅是搅匀","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102107_18048.jpg"},{"pcontent":"将面团揉成长条","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102107_92150.jpg"},{"pcontent":"揪成剂子","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102107_75347.jpg"},{"pcontent":"按扁，擀成薄饼","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102107_43510.jpg"},{"pcontent":"取一面皮，放入适量的馅","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102107_30024.jpg"},{"pcontent":"对折，将边缘捏合","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102108_46645.jpg"},{"pcontent":"在捏个花边，也可用叉子压成花边","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102108_57715.jpg"},{"pcontent":"电饼铛预热，刷一层油","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102108_29225.jpg"},{"pcontent":"放入包好的盒子煎至金黄","pic":"http://api.jisuapi
         * .com/recipe/upload/20160802/102108_19328.jpg"},{"pcontent":"翻面，烙至两面金黄（中间可盖盖，焖至一两分）","pic":"http://api
         * .jisuapi.com/recipe/upload/20160802/102108_35457.jpg"}]},{"id":"28471","classid":"319",
         * "name":"属（薯）我妈妈最美丽","peoplenum":"1-2人","preparetime":"10分钟内","cookingtime":"10-20分钟",
         * "content":"又到了一年一度的母亲节，小朋友都想好送什么礼物了吗？我觉得礼物不重要，心意最可贵，今天来教小朋友做一款超级简单的美食：属（薯）你最美\u2014\u2014
         * 我的妈妈，妈妈在我们心目中一定是世界上最最美丽的女人，快来发挥自己的想象力，做个美丽的妈妈送妈妈吧。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160719/180915_24422.jpg","tag":"儿童,创意菜,卡通,宝宝,小吃,母亲节,婴儿辅食","material":[{"mname":"蓝莓干",
         * "type":"0","amount":"2个"},{"mname":"白心红薯","type":"1","amount":"1个"},{"mname":"小紫薯","type":"1",
         * "amount":"2个"},{"mname":"草莓","type":"1","amount":"10个"},{"mname":"黄瓜","type":"1","amount":"半根"}],
         * "process":[{"pcontent":"准备好食材。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160804/161259_15624
         * .jpg"},{"pcontent":"妈妈帮忙把红薯和紫薯切片。<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160804/161259_89191.jpg"},{"pcontent":"然后上锅蒸熟。<br />\n<br />\n","pic":"http://api
         * .jisuapi.com/recipe/upload/20160804/161300_26495.jpg"},
         * {"pcontent":"这一步小朋友就可以自己操作了，首先要把白色红薯过筛成泥，筛子洗干净后再把紫薯过筛成泥。<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160804/161300_37456.jpg"},{"pcontent":"过筛好的白色红薯泥用一个垫了保鲜膜的圆碗填入红薯泥压实再倒扣到盘子中去掉保鲜膜。<br 
         * />\n","pic":"http://api.jisuapi.com/recipe/upload/20160804/161300_68369.jpg"},
         * {"pcontent":"然后用勺子在旁边放上紫薯头发。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160804/161300_83652
         * .jpg"},{"pcontent":"草莓洗净后用刀竖着将四面切掉，然后在宽的那一头修成锯齿状。<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160804/161301_44558.jpg"},{"pcontent":"用削皮刀将黄瓜削去皮，用剪刀剪成花杆，叶子，花托。<br />\n",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160804/161301_18706.jpg"},
         * {"pcontent":"蓝莓干做眼睛，一点红薯泥做鼻子，用勺子画一个嘴巴，把切好的草莓按照下面四瓣上面三瓣摆放，装上花托、花杆、叶子组合成康乃馨，多余的草莓切点爱心和红脸蛋。",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160804/161301_39444.jpg"}]},{"id":"30545","classid":"332",
         * "name":"我家汤圆","peoplenum":"1-2人","preparetime":"30分钟-1小时","cookingtime":"10-20分钟",
         * "content":"元宵佳节，每家每户，都会吃上一碗的汤圆。往年都是习惯性的直接买包装好的。但是，越来越喜欢玩美食DIY，对神马都想DIY尝试一下。再一个，吃着自己DIY
         * 的舒心，与家人一同制作的过程，就是个温暖，海皮。我家汤圆，我爱我家。","pic":"http://api.jisuapi.com/recipe/upload/20160719/181505_34231
         * .jpg","tag":"元宵节,汤圆,香甜","material":[{"mname":"柚子酱","type":"0","amount":"适量"},{"mname":"玫瑰花酱","type":"0",
         * "amount":"适量"},{"mname":"核桃","type":"0","amount":"适量"},{"mname":"枸杞","type":"0","amount":"适量"},
         * {"mname":"醪糟","type":"0","amount":"适量"},{"mname":"汤圆粉","type":"1","amount":"400g"},{"mname":"汤圆心子",
         * "type":"1","amount":"200g"}],"process":[{"pcontent":"准备用的汤圆粉，还有汤圆心子。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160804/121112_53294.jpg"},{"pcontent":"核桃（切碎炒熟）","pic":"http://api.jisuapi
         * .com/recipe/upload/20160804/121112_74634.jpg"},{"pcontent":"取适量的柚子酱，玫瑰花酱，汤圆心子，核桃（切碎炒熟），调匀制成馅料。<br />\n",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160804/121112_24991.jpg"},{"pcontent":"汤圆粉用温水，和匀。",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160804/121113_64343.jpg"},{"pcontent":"揉成团，醒一会儿。<br />\n",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160804/121113_10717.jpg"},
         * {"pcontent":"将醒好的面团，擀成小剂子后，把馅料调匀的，包进去，再用掌心，慢慢揉成汤圆状。放置在撒有面料的盘子上。<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160804/121114_55159.jpg"},{"pcontent":"洗净的枸杞子。","pic":"http://api.jisuapi
         * .com/recipe/upload/20160804/121114_15202.jpg"},
         * {"pcontent":"锅里倒上热水，把醪糟倒入一同煮之，等开锅后，放入包至好的汤圆，与枸杞，大火烧开，待汤圆都漂起来了，再煮3分钟。<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160804/121115_45385.jpg"},{"pcontent":"将煮好的汤圆盛到碗里，我家汤圆，这就做好了。<br />\n",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160804/121115_54872.jpg"}]},{"id":"34419","classid":"352",
         * "name":"熊猫鸡蛋羹---爱我你就吃掉我","peoplenum":"1-2人","preparetime":"10-20分钟","cookingtime":"10-20分钟",
         * "content":"大熊猫是一种有着独特黑白相间毛色的活泼动物,以竹子为主要食物,它那憨态可掬的样子深受人们的喜爱,特别是小朋友的喜爱.我家就有位小朋友,虽然今年已经13岁了,
         * 可调皮捣蛋起来就像个长不大的孩子一样,这不这两天总和我嚷嚷嗓子疼,又不好好吃饭了.怎么办呢?当妈的总是把自己的孩子当作生命一样,谁会不在乎自己的&quot;生命&quot;呢
         * .我就开始琢磨给儿子做点什么容易下咽的食物了,当然还要有营养的.鸡蛋--那可是孩子成长不可或缺的好东西,芝麻含有大量的脂肪和蛋白质,还有膳食纤维、维生素B1、B2、尼克酸、维生素E、卵磷脂、钙、铁、镁等营养成分
         * .儿子带给我的动力成就了今天这道菜----芝麻鸡蛋羹,祝儿子身体健康,快乐成长.祝小朋友们像大熊猫一样活泼可爱.","pic":"http://api.jisuapi
         * .com/recipe/upload/20160719/183053_80890.jpg","tag":"其他,10-20分钟,羹,熬,鲜香,全菜系,1-2人",
         * "material":[{"mname":"白芝麻","type":"0","amount":"适量"},{"mname":"黑芝麻","type":"0","amount":"适量"},
         * {"mname":"盐","type":"0","amount":"适量"},{"mname":"胡椒粉","type":"0","amount":"适量"},{"mname":"香菜","type":"0",
         * "amount":"适量"},{"mname":"油","type":"0","amount":"适量"},{"mname":"鸡蛋","type":"1","amount":"2个"}],
         * "process":[{"pcontent":"取一大碗倒入少许的油摇匀<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160805/114211_19719.jpg"},{"pcontent":"打入两个鸡蛋","pic":"http://api.jisuapi
         * .com/recipe/upload/20160805/114211_67536.jpg"},{"pcontent":"碗里加入适量的精盐搅匀,倒入60度左右的热水使劲抽打蛋液,搅好的鸡蛋液上锅蒸,开锅蒸10分钟
         * .<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114212_25095.jpg"},
         * {"pcontent":"蒸好的鸡蛋羹取出后晾凉.<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114212_63957
         * .jpg"},{"pcontent":"准备黑,白芝麻","pic":"http://api.jisuapi.com/recipe/upload/20160805/114212_60723.jpg"},
         * {"pcontent":"用牙签在鸡蛋羹上面轻轻点出熊猫的基本轮廓","pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_17237
         * .jpg"},{"pcontent":"用纸卷成漏斗形状","pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_44414.jpg"},
         * {"pcontent":"分别装上少许白,黑芝麻在鸡蛋羹上<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_73707
         * .jpg"},{"pcontent":"分别装上少许白,黑芝麻在鸡蛋羹上撒出熊猫的图案.<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160805/114213_57385.jpg"},{"pcontent":"撒出熊猫的图案.<br />\n","pic":"http://api.jisuapi
         * .com/recipe/upload/20160805/114213_56249.jpg"},{"pcontent":"最后用香菜做为竹子的形像摆布在熊猫下面.<br />\n",
         * "pic":"http://api.jisuapi.com/recipe/upload/20160805/114214_12754.jpg"}]},{"id":"37348","classid":"364",
         * "name":"章鱼炒面便当\u2014你侬我侬","peoplenum":"1-2人","preparetime":"10分钟内","cookingtime":"30分钟-1小时",
         * "content":"从前有一个男孩很爱一个漂亮的女孩，他总是默默的走在女孩后面保护她，女孩的脸上很少看到笑容，她最大的心愿就是想去看海，海离他们太远了，男孩没有足够的钱带心爱的女孩去海边，为了让女孩开心男孩想尽了各种办法，春天终于来了，漫山遍野开满了鲜艳的花儿，男孩也赚到了足够多的钱可以带女孩去海边了，他们看到了两只可爱的章鱼，章鱼先生为了取悦心爱的章鱼小姐亮出了自己的绝活\u2014\u2014中国功夫，章鱼小姐为了吸引章鱼先生翩翩起舞，终于女孩笑了，笑得那么美，男孩依然在女孩的后面默默的保护着她，后来他们过上了幸福的生活。（本故事纯属虚构，如有雷同纯属巧合！哈哈，我现在发现做完便当我脑子里就蹦出故事了）","pic":"http://api.jisuapi.com/recipe/upload/20160720/090358_71168.jpg","tag":"便当,儿童,炒粉","material":[{"mname":"油","type":"0","amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},{"mname":"青菜","type":"0","amount":"100g"},{"mname":"心里美萝卜","type":"0","amount":"50g"},{"mname":"胡萝卜泡菜","type":"0","amount":"50g"},{"mname":"鸡蛋","type":"0","amount":"2个"},{"mname":"蟹肉棒","type":"0","amount":"适量"},{"mname":"生菜","type":"0","amount":"适量"},{"mname":"香肠","type":"0","amount":"100g"},{"mname":"雪梨","type":"0","amount":"250g"},{"mname":"小番茄","type":"0","amount":"20g"},{"mname":"海带","type":"0","amount":"适量"},{"mname":"白醋","type":"0","amount":"适量"},{"mname":"酱油","type":"0","amount":"适量"},{"mname":"熟面条","type":"1","amount":"200g"}],"process":[{"pcontent":"准备好食材。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_88585.jpg"},{"pcontent":"心里美萝卜切薄片用食盐和白醋腌制入味，将青菜切好备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_19074.jpg"},{"pcontent":"香肠对半切开，用刀竖着切至二分之一处成八条。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_74071.jpg"},{"pcontent":"用水将香肠、蟹肉棒、1个鸡蛋、海带煮熟备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_81811.jpg"},{"pcontent":"炒锅油热后倒入蛋液和青菜翻炒。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_97913.jpg"},{"pcontent":"接着放入食盐和酱油炒至7成熟。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_33293.jpg"},{"pcontent":"放入熟面条翻炒均匀出锅。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_73866.jpg"},{"pcontent":"将炒面放入便当盒。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_91501.jpg"},{"pcontent":"将煮熟的香肠和蟹肉棒取出，将蟹肉棒打开压出章鱼的眼睛和嘴巴粘在香肠上。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_61147.jpg"},{"pcontent":"用胡萝卜泡菜压出蝴蝶结戴在女章鱼头上。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_57979.jpg"},{"pcontent":"同样用胡萝卜泡菜修成一顶帽子戴在男章鱼头上。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_90936.jpg"},{"pcontent":"将胡萝卜泡菜切成花形。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_84362.jpg"},{"pcontent":"用模具在上面打孔。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_20464.jpg"},{"pcontent":"如图打六个孔。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_38830.jpg"},{"pcontent":"腌好的心里美萝卜用模具压出花形。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_57845.jpg"},{"pcontent":"和胡萝卜一样打孔，打出来的小边角料刚好放入胡萝卜的孔里。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_79145.jpg"},{"pcontent":"鸡蛋对半切开，用海带压出头发、眼睛分别做成男孩女孩。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112935_10480.jpg"},{"pcontent":"挖球器将梨挖成球状。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112935_12402.jpg"},{"pcontent":"将做好的食物摆在合适位置即可。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112935_35159.jpg"}]},{"id":"39474","classid":"382","name":"粽子---做给我们尊敬的父亲大人","peoplenum":"6人以上","preparetime":"2小时以上","cookingtime":"2小时以上","content":"80多岁的父亲年数已高，今年牙齿也开始脱落了部分，很多东西都嚼不动了，在我的记忆里，父亲极少下厨，只有当妈妈出远门了，无法赶回来做饭，我和弟弟就会扁扁嘴：今天是爸爸煮饭。唉！。。。那顿饭吃得很磨叽，然后端着碗去奶奶那噌菜吃，然而父亲也有杀手锏，父亲最拿手的菜就是：酸菜炒猪大肠。记得十年前，常年在外工作的大哥休息日回家还经常会说：爸爸，明天吃猪大肠咯。 然后父亲就会笑嘻嘻的反问：想吃猪大肠？ 叫你妈妈明天早上买猪大肠回来啊。 妈妈一大早去早市买了猪大肠回来，父亲就开始动工了，父亲是那种慢工磨细活的人，一副猪大肠他需要花一个早上来洗干净，洗到完全没有异味。往往这个时候，我家姐夫就会说：爸，不要洗那么干净，有味道才更好吃呢。父亲从洗猪大肠、酸菜，到炒好，全程不让人帮忙，自己完成，父亲炒的猪大肠爽口不韧，酸甜可口，是父亲唯一做的让我们想念的美味。一个月大概能吃一到2次酸菜炒猪大肠。父亲属于少言寡语，每每我们要求他出手做猪大肠，那天他会特别的开心，被需要是种幸福。后来父亲出了车祸，手脚不灵便了，从此我们再没有吃过酸菜炒猪大肠啦。<br />     过年的时候，我特地买了很多果仁回家，想着父亲无聊时可以吃吃零嘴，才知道父亲牙齿脱落了，已经嚼不动果仁啦，我心里很酸，很惶恐 子欲养而亲不在那感觉一直纠缠着我的思维。把果仁拿去请人磨成粉，这样父亲可以用开水冲来喝，父亲喜欢喝。<br />     我们的奶奶一辈子没有离开过酒和茶，但我们一身书生气的父亲却一辈子烟酒不沾，喜欢吃糕点，呵呵，老人象孩童，这话不假，老父亲就象孩子似的，一天到晚不停地找东西吃。哥哥弟弟回家也会带父亲喜欢的点心，姐姐们离父母近些，她们每周都会给父亲做些小吃送过去，姐姐包的粽子，父亲一次可以吃2个。这个父亲节，女儿不做下酒菜，一起包粽子孝敬我们的父亲，希望父亲身体健康，多享几年儿孙福，父亲节快乐！","pic":"http://api.jisuapi.com/recipe/upload/20160720/092115_58187.jpg","tag":"端午节,粽子,下酒菜","material":[{"mname":"咸蛋黄","type":"0","amount":"适量"},{"mname":"叉烧","type":"0","amount":"400g"},{"mname":"五花肉","type":"0","amount":"500g"},{"mname":"虾米","type":"0","amount":"250g"},{"mname":"油","type":"0","amount":"适量"},{"mname":"生抽","type":"0","amount":"适量"},{"mname":"胡椒粉","type":"0","amount":"适量"},{"mname":"料酒","type":"0","amount":"适量"},{"mname":"南乳","type":"0","amount":"1块"},{"mname":"鸡精","type":"0","amount":"适量"},{"mname":"红葱头","type":"0","amount":"适量"},{"mname":"糯米","type":"1","amount":"1500g"},{"mname":"红豆","type":"1","amount":"500g"}],"process":[{"pcontent":"材料：糯米，红豆，五花肉，叉烧，虾米，咸蛋黄，棕叶，粽篾。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152237_99628.jpg"},{"pcontent":"首先提前一天浸泡粽叶和粽篾，泡软了，在用之前洗净。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_48192.jpg"},{"pcontent":"咸蛋黄用线一开二，切开。<br />\n这是自家提22天腌制的咸蛋黄，又香又油，我们是一个粽子半个咸蛋黄，可按个人喜好切分。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_40164.jpg"},{"pcontent":"叉烧切块，备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_68166.jpg"},{"pcontent":"红豆隔天晚上浸泡，用之前洗净。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_55492.jpg"},{"pcontent":"糯米提前1小时左右浸泡，洗净。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_92870.jpg"},{"pcontent":"浸泡洗净的糯米。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_48090.jpg"},{"pcontent":"洗净的糯米和红豆","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_26905.jpg"},{"pcontent":"糯米，红豆放点油和适量盐和生抽，调味 拌匀。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_80958.jpg"},{"pcontent":"五花肉切块","pic":"http://api.jisuapi.com/recipe/upload/20160805/152240_53079.jpg"},{"pcontent":"红葱头剁碎","pic":"http://api.jisuapi.com/recipe/upload/20160805/152240_88392.jpg"},{"pcontent":"调料：料酒，胡椒粉，四季酱，南乳，鸡精，盐。生抽。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_10913.jpg"},{"pcontent":"热油锅爆香红葱蓉，放点盐一起爆香","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_47707.jpg"},{"pcontent":"放入五花肉，放南乳。。。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_21948.jpg"},{"pcontent":"放四季酱，料酒，胡椒粉，南乳，鸡精。生抽。翻炒","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_12548.jpg"},{"pcontent":"不停翻炒","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_55683.jpg"},{"pcontent":"翻炒到五花肉均匀沾上酱汁 翻炒至变色即可。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152242_89560.jpg"},{"pcontent":"放了调料翻炒过多五花肉，很香的","pic":"http://api.jisuapi.com/recipe/upload/20160805/152242_72744.jpg"},{"pcontent":"虾米放锅里炒香 盛出备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152242_93883.jpg"},{"pcontent":"都准备好了 要开始包粽子啦","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_57258.jpg"},{"pcontent":"2-3片粽叶先对弯成漏斗形，抓一把糯米，然后依次放近五花肉、叉烧，虾米，半个咸蛋黄，再抓一把糯米红豆覆盖在上面，把上面的粽叶往下覆盖，捻紧折向一边，包成一个四角的粽子，然后用泡软洗净的粽篾帮紧，OK.","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_54890.jpg"},{"pcontent":"包好的粽子 4个不对称的角组成。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_89182.jpg"},{"pcontent":"粽子","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_86032.jpg"},{"pcontent":"包好的粽子 开水下锅，","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_88909.jpg"},{"pcontent":"大火煲1.5小时关火 虚火3-5分钟<br />\n姐姐说高压锅压没那么好吃，所以选择这个锅慢慢煲。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_51118.jpg"},{"pcontent":"煲好的粽子 要提起 不要一直浸泡在锅里，挂起来，这样可以保存的时间更长些。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_35404.jpg"},{"pcontent":"漂亮又好吃的大肉咸蛋粽 ","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_69183.jpg"}]},{"id":"53517","classid":"586","name":"我的爸爸饭团","peoplenum":"1-2人","preparetime":"10分钟内","cookingtime":"30分钟-1小时","content":"辰辰是个很喜欢画画的孩子，于是本子上，我们家的墙上到处都是辰辰的大作，今天这一幅我的爸爸就是来自于我家墙上辰辰的大作，周日就是父亲节了，想着做个跟父亲有关的美食，找了一些图片后我就想起辰辰也画了好多爸爸啊，何不把辰辰心目中的爸爸做出来，这也算是一份比较特别的父亲节礼物吧，爸爸在辰辰心目中是穿着铮亮的皮鞋，提着一个大大的包，大大的肚子，长长的胳膊长长的腿，只是竟然木长头发呢，爸爸在孩子心目中的形象总是千奇百怪的，记得小时候老师布置的作文有我的爸爸，每次也都会天马行空的乱写一通，爸爸就像一座房子为我们遮风挡雨，爸爸就像一棵大树伟岸挺拔，爸爸是一盏灯，坚定不移，永远引导我驶入安全的港湾;爸爸是一座知识宝库，挖掘不尽，甘愿为我解难答疑。<br />　　有一次忘了在说什么了，辰辰问谁啊？我说你爹，辰辰问啥是爹啊？我说爸爸就是爹，从那以后辰辰有事没事就管她爸爸叫爹，爹，你在干嘛？爹，我叫你为啥不答应？还跟我说：娘，我爹咋不理我呢？我说你爹忙着呢，辰爸每天都很忙，辰辰希望爸爸可以经常陪她玩，可是爸爸要为了她美好的未来努力工作，辰辰想像爸爸一样会开车，像爸爸一样去工作，辰辰内心是很崇拜爸爸的，周日就父亲节了，祝辰辰的爸和辰辰的老爷节日快乐！","pic":"http://api.jisuapi.com/recipe/upload/20160720/121831_52717.jpg","tag":"儿童,创意菜,午餐,父亲节","material":[{"mname":"油","type":"0","amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},{"mname":"海苔","type":"0","amount":"适量"},{"mname":"虾皮粉","type":"0","amount":"适量"},{"mname":"番茄酱","type":"0","amount":"适量"},{"mname":"生菜","type":"0","amount":"适量"},{"mname":"熟鹌鹑蛋","type":"0","amount":"适量"},{"mname":"米饭","type":"1","amount":"150g"},{"mname":"奶酪片","type":"1","amount":"2片"},{"mname":"西兰花","type":"1","amount":"50g"}],"process":[{"pcontent":"准备好食材。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142614_26205.jpg"},{"pcontent":"将米饭和番茄酱一起拌匀。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_55066.jpg"},{"pcontent":"米饭用保鲜膜团出头部。<br />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_66499.jpg"},{"pcontent":"继续团出身体用生菜叶包住。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_98789.jpg"},{"pcontent":"鹌鹑蛋切掉顶端做眼睛。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_83395.jpg"},{"pcontent":"海苔做嘴巴和眼睛，生菜在包两个长条米饭做胳膊。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_57330.jpg"},{"pcontent":"炒锅油热后放入西兰花翻炒片刻，加少许食盐、水、虾皮粉炒熟出锅。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_79528.jpg"},{"pcontent":"奶酪片、海苔做出裤子、领带，宝宝、鞋子等。<br />\n<br />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142616_94653.jpg"}]}]}
         */

        private String status;
        private String msg;
        private ResultBean result;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * num : 9
             * list : [{"id":"16842","classid":"133","name":"芒果冰激凌\u2014夏天里我最喜欢的水果味","peoplenum":"5-6人",
             * "preparetime":"10分钟内","cookingtime":"2小时以上",
             * "content":"夏天怎么能少的了自己在家做的冰激凌呢，有了草莓的，抹茶的，可我最爱的水果就是芒果了，怎么又能少了芒果冰激凌呢！自己在家做的卫生有好吃，芒果味十足，降温的好甜品o !",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160719/154535_26015.jpg","tag":"儿童,冰品,冰淇淋,白领",
             * "material":[{"mname":"细砂糖","type":"0","amount":"150g"},{"mname":"盐","type":"0","amount":"2g"},
             * {"mname":"蛋黄","type":"1","amount":"3个"},{"mname":"芒果泥","type":"1","amount":"300g"},{"mname":"动物性淡奶油",
             * "type":"1","amount":"250ml"},{"mname":"牛奶","type":"1","amount":"380ml"}],
             * "process":[{"pcontent":"准备好所有材料。<br />\n<br />\n<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/102249_17398.jpg"},{"pcontent":"3个蛋黄，细砂糖，盐，牛奶倒入小锅搅拌均匀。<br />\n",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102249_89239.jpg"},
             * {"pcontent":"小火加热奶锅并不断搅拌，直到沸腾立即离火，放到一边冷却。<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/102249_27040.jpg"},{"pcontent":"芒果去皮打成芒果泥，多打一会，这样出来的果肉细腻。<br />\n<br 
             * />\n","pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_85095.jpg"},
             * {"pcontent":"冷却后的蛋奶液，加入打好的芒果泥。<br />\n<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/102250_36477.jpg"},{"pcontent":"芒果泥和蛋奶液搅拌均匀。<br />\n<br />\n",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_32367.jpg"},
             * {"pcontent":"淡奶油用打蛋器打发至6，7分。<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/102250_10602.jpg"},{"pcontent":"芒果蛋奶液加入淡奶油里。<br />\n<br />\n",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_58489.jpg"},
             * {"pcontent":"搅拌均匀成冰激凌液，放入冰箱冷冻。<br />\n<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/102251_77098.jpg"},
             * {"pcontent":"冰淇淋液冷冻到结冰，取出来用电动打蛋器搅一会，再放入冰箱冷冻。之后每隔半个小时取出来搅打一次。重复搅打4次以上，将冰激凌冻硬就做好了。<br />\n",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102251_97027.jpg"}]},{"id":"19347",
             * "classid":"182","name":"苦瓜炒饭\u2014\u2014我的另类苦瓜吃法","peoplenum":"1-2人","preparetime":"10-20分钟",
             * "cookingtime":"10-20分钟",
             * "content":"感觉自己这次的苦瓜吃法比较另类，很喜欢苦瓜，通常都是用蒜蓉豆豉炒苦瓜为多，这次的食材也没变，另类在于我用它来炒饭了！让米饭渗透了苦瓜、豆豉、蒜蓉的香味，吃得很过瘾。<br />  
             * 苦瓜性寒味苦、入心、肺、胃，具有清闵解渴、降血压、血脂、养颜美容、促进新陈代谢等功能。苦瓜含丰富的维生素B1、维生素C及矿物质，能保持精力旺盛，对治疗青春痘有很大益处。<br /><br />   
             * 苦瓜中的苦瓜素被誉为\u201c脂肪杀手\u201d所以，常吃苦瓜也可以起到减肥作用。苦瓜中的有效成分可以仰制正常细胞的癌变和促进突变细胞的复原，具有一定的抗癌作用。苦瓜的维生素C
             * 含量很高，具有预防坏血病、保护细胞膜、防止动脉粥样硬化、提高机体应激能力、保护心脏等作用。<br /> 看来平常多吃苦瓜还是好处多多的哦。","pic":"http://api.jisuapi
             * .com/recipe/upload/20160719/161433_37269.jpg","tag":"夏季,夏季饮食,脂肪肝,胃寒,阳盛质,牙痛",
             * "material":[{"mname":"橄榄油","type":"0","amount":"适量"},{"mname":"生抽","type":"0","amount":"适量"},
             * {"mname":"鸡精","type":"0","amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},{"mname":"蒜蓉",
             * "type":"0","amount":"适量"},{"mname":"豆豉","type":"0","amount":"适量"},{"mname":"苦瓜","type":"1",
             * "amount":"1个"},{"mname":"米饭","type":"1","amount":"1大碗"}],"process":[{"pcontent":"先把苦瓜去囊切成小粒状。",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/104140_60486.jpg"},
             * {"pcontent":"烧热锅倒入适量橄榄油，放入大蒜后再倒入豆豉炒出香味。","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/104141_53452.jpg"},{"pcontent":"加入切成小料到的苦瓜一起炒。","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/104141_66741.jpg"},{"pcontent":"炒至苦瓜变软，放少许盐，盛起备用。","pic":"http://api
             * .jisuapi.com/recipe/upload/20160802/104141_47054.jpg"},{"pcontent":"使用原来的油锅倒入米饭。","pic":"http://api
             * .jisuapi.com/recipe/upload/20160802/104142_12367.jpg"},{"pcontent":"翻炒片刻加入少许生抽继续炒均匀。",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/104142_62710.jpg"},{"pcontent":"再将炒好的苦瓜加入。",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/104142_45268.jpg"},{"pcontent":"放入少许鸡精炒均匀后即可熄火。",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/104143_21498.jpg"}]},{"id":"20123",
             * "classid":"187","name":"韭菜盒子--我为妈妈做","peoplenum":"1-2人","preparetime":"30分钟-1小时",
             * "cookingtime":"30分钟-1小时",
             * "content":"小时候，经常跟着妈妈在厨房里忙活，虽然帮不上什么忙但也能打个下手。和妈妈一起挑韭菜，再跟着妈妈一步一步的学着包盒子，妈妈总是说\u201c这捏褶的活啊，你爷爷捏的好看了\u201d
             * 。每次包盒子妈妈总这样说。韭菜鸡蛋盒子很香，加了虾皮就更加鲜亮了，让人胃口大开，我很喜欢吃，妈妈也喜欢吃，这次由我为妈妈做她最爱吃的韭菜盒子，希望妈妈永远健康快乐。","pic":"http://api
             * .jisuapi.com/recipe/upload/20160719/162220_57459.jpg","tag":"阳虚质,春季,妈妈菜,电饼铛,尿频,补肝,阳痿",
             * "material":[{"mname":"油","type":"0","amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},
             * {"mname":"料酒","type":"0","amount":"适量"},{"mname":"花椒粉","type":"0","amount":"适量"},{"mname":"虾皮",
             * "type":"0","amount":"适量"},{"mname":"韭菜","type":"1","amount":"150g"},{"mname":"鸡蛋","type":"1",
             * "amount":"4个"},{"mname":"面粉","type":"1","amount":"1碗"}],"process":[{"pcontent":"面粉用水和成光滑的面团，放一旁饧至",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102105_17799.jpg"},{"pcontent":"鸡蛋加适量的盐和料酒搅匀",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102105_72470.jpg"},
             * {"pcontent":"热锅热油，一边倒蛋液一边用筷子不停的搅动，将鸡蛋炒成小块，晾凉","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/102106_79199.jpg"},{"pcontent":"韭菜洗净控水，切碎","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/102106_81968.jpg"},{"pcontent":"放入适量的花椒粉拌匀","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/102106_82338.jpg"},{"pcontent":"再放入油拌匀，这样韭菜不易出汤","pic":"http://api.jisuapi
             * .com/recipe/upload/20160802/102106_30321.jpg"},{"pcontent":"将晾凉的鸡蛋和洗净的虾皮，少许盐放入韭菜里，待包馅是搅匀",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102107_18048.jpg"},{"pcontent":"将面团揉成长条",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102107_92150.jpg"},{"pcontent":"揪成剂子",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102107_75347.jpg"},{"pcontent":"按扁，擀成薄饼",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102107_43510.jpg"},{"pcontent":"取一面皮，放入适量的馅",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102107_30024.jpg"},{"pcontent":"对折，将边缘捏合",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102108_46645.jpg"},{"pcontent":"在捏个花边，也可用叉子压成花边",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102108_57715.jpg"},{"pcontent":"电饼铛预热，刷一层油",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102108_29225.jpg"},{"pcontent":"放入包好的盒子煎至金黄",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102108_19328.jpg"},
             * {"pcontent":"翻面，烙至两面金黄（中间可盖盖，焖至一两分）","pic":"http://api.jisuapi.com/recipe/upload/20160802/102108_35457
             * .jpg"}]},{"id":"28471","classid":"319","name":"属（薯）我妈妈最美丽","peoplenum":"1-2人","preparetime":"10分钟内",
             * "cookingtime":"10-20分钟",
             * "content":"又到了一年一度的母亲节，小朋友都想好送什么礼物了吗？我觉得礼物不重要，心意最可贵，今天来教小朋友做一款超级简单的美食：属（薯）你最美\u2014\u2014
             * 我的妈妈，妈妈在我们心目中一定是世界上最最美丽的女人，快来发挥自己的想象力，做个美丽的妈妈送妈妈吧。","pic":"http://api.jisuapi
             * .com/recipe/upload/20160719/180915_24422.jpg","tag":"儿童,创意菜,卡通,宝宝,小吃,母亲节,婴儿辅食",
             * "material":[{"mname":"蓝莓干","type":"0","amount":"2个"},{"mname":"白心红薯","type":"1","amount":"1个"},
             * {"mname":"小紫薯","type":"1","amount":"2个"},{"mname":"草莓","type":"1","amount":"10个"},{"mname":"黄瓜",
             * "type":"1","amount":"半根"}],"process":[{"pcontent":"准备好食材。<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160804/161259_15624.jpg"},{"pcontent":"妈妈帮忙把红薯和紫薯切片。<br />\n","pic":"http://api
             * .jisuapi.com/recipe/upload/20160804/161259_89191.jpg"},{"pcontent":"然后上锅蒸熟。<br />\n<br />\n",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160804/161300_26495.jpg"},
             * {"pcontent":"这一步小朋友就可以自己操作了，首先要把白色红薯过筛成泥，筛子洗干净后再把紫薯过筛成泥。<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160804/161300_37456.jpg"},
             * {"pcontent":"过筛好的白色红薯泥用一个垫了保鲜膜的圆碗填入红薯泥压实再倒扣到盘子中去掉保鲜膜。<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160804/161300_68369.jpg"},{"pcontent":"然后用勺子在旁边放上紫薯头发。<br />\n","pic":"http://api
             * .jisuapi.com/recipe/upload/20160804/161300_83652.jpg"},{"pcontent":"草莓洗净后用刀竖着将四面切掉，然后在宽的那一头修成锯齿状。<br 
             * />\n","pic":"http://api.jisuapi.com/recipe/upload/20160804/161301_44558.jpg"},
             * {"pcontent":"用削皮刀将黄瓜削去皮，用剪刀剪成花杆，叶子，花托。<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160804/161301_18706.jpg"},
             * {"pcontent":"蓝莓干做眼睛，一点红薯泥做鼻子，用勺子画一个嘴巴，把切好的草莓按照下面四瓣上面三瓣摆放，装上花托、花杆、叶子组合成康乃馨，多余的草莓切点爱心和红脸蛋。",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160804/161301_39444.jpg"}]},{"id":"30545",
             * "classid":"332","name":"我家汤圆","peoplenum":"1-2人","preparetime":"30分钟-1小时","cookingtime":"10-20分钟",
             * "content":"元宵佳节，每家每户，都会吃上一碗的汤圆。往年都是习惯性的直接买包装好的。但是，越来越喜欢玩美食DIY，对神马都想DIY尝试一下。再一个，吃着自己DIY
             * 的舒心，与家人一同制作的过程，就是个温暖，海皮。我家汤圆，我爱我家。","pic":"http://api.jisuapi.com/recipe/upload/20160719/181505_34231
             * .jpg","tag":"元宵节,汤圆,香甜","material":[{"mname":"柚子酱","type":"0","amount":"适量"},{"mname":"玫瑰花酱",
             * "type":"0","amount":"适量"},{"mname":"核桃","type":"0","amount":"适量"},{"mname":"枸杞","type":"0",
             * "amount":"适量"},{"mname":"醪糟","type":"0","amount":"适量"},{"mname":"汤圆粉","type":"1","amount":"400g"},
             * {"mname":"汤圆心子","type":"1","amount":"200g"}],"process":[{"pcontent":"准备用的汤圆粉，还有汤圆心子。",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160804/121112_53294.jpg"},{"pcontent":"核桃（切碎炒熟）",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160804/121112_74634.jpg"},
             * {"pcontent":"取适量的柚子酱，玫瑰花酱，汤圆心子，核桃（切碎炒熟），调匀制成馅料。<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160804/121112_24991.jpg"},{"pcontent":"汤圆粉用温水，和匀。","pic":"http://api.jisuapi
             * .com/recipe/upload/20160804/121113_64343.jpg"},{"pcontent":"揉成团，醒一会儿。<br />\n","pic":"http://api
             * .jisuapi.com/recipe/upload/20160804/121113_10717.jpg"},
             * {"pcontent":"将醒好的面团，擀成小剂子后，把馅料调匀的，包进去，再用掌心，慢慢揉成汤圆状。放置在撒有面料的盘子上。<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160804/121114_55159.jpg"},{"pcontent":"洗净的枸杞子。","pic":"http://api.jisuapi
             * .com/recipe/upload/20160804/121114_15202.jpg"},
             * {"pcontent":"锅里倒上热水，把醪糟倒入一同煮之，等开锅后，放入包至好的汤圆，与枸杞，大火烧开，待汤圆都漂起来了，再煮3分钟。<br />\n","pic":"http://api
             * .jisuapi.com/recipe/upload/20160804/121115_45385.jpg"},{"pcontent":"将煮好的汤圆盛到碗里，我家汤圆，这就做好了。<br />\n",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160804/121115_54872.jpg"}]},{"id":"34419",
             * "classid":"352","name":"熊猫鸡蛋羹---爱我你就吃掉我","peoplenum":"1-2人","preparetime":"10-20分钟",
             * "cookingtime":"10-20分钟","content":"大熊猫是一种有着独特黑白相间毛色的活泼动物,以竹子为主要食物,它那憨态可掬的样子深受人们的喜爱,特别是小朋友的喜爱.我家就有位小朋友,
             * 虽然今年已经13岁了,可调皮捣蛋起来就像个长不大的孩子一样,这不这两天总和我嚷嚷嗓子疼,又不好好吃饭了.怎么办呢?当妈的总是把自己的孩子当作生命一样,谁会不在乎自己的&quot;生命&quot;呢
             * .我就开始琢磨给儿子做点什么容易下咽的食物了,当然还要有营养的.鸡蛋--那可是孩子成长不可或缺的好东西,芝麻含有大量的脂肪和蛋白质,
             * 还有膳食纤维、维生素B1、B2、尼克酸、维生素E、卵磷脂、钙、铁、镁等营养成分.儿子带给我的动力成就了今天这道菜----芝麻鸡蛋羹,祝儿子身体健康,快乐成长.祝小朋友们像大熊猫一样活泼可爱.",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160719/183053_80890.jpg","tag":"其他,10-20分钟,羹,熬,鲜香,全菜系,
             * 1-2人","material":[{"mname":"白芝麻","type":"0","amount":"适量"},{"mname":"黑芝麻","type":"0","amount":"适量"},
             * {"mname":"盐","type":"0","amount":"适量"},{"mname":"胡椒粉","type":"0","amount":"适量"},{"mname":"香菜",
             * "type":"0","amount":"适量"},{"mname":"油","type":"0","amount":"适量"},{"mname":"鸡蛋","type":"1",
             * "amount":"2个"}],"process":[{"pcontent":"取一大碗倒入少许的油摇匀<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160805/114211_19719.jpg"},{"pcontent":"打入两个鸡蛋","pic":"http://api.jisuapi
             * .com/recipe/upload/20160805/114211_67536.jpg"},{"pcontent":"碗里加入适量的精盐搅匀,倒入60度左右的热水使劲抽打蛋液,搅好的鸡蛋液上锅蒸,
             * 开锅蒸10分钟.<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114212_25095.jpg"},
             * {"pcontent":"蒸好的鸡蛋羹取出后晾凉.<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114212_63957
             * .jpg"},{"pcontent":"准备黑,白芝麻","pic":"http://api.jisuapi.com/recipe/upload/20160805/114212_60723.jpg"},
             * {"pcontent":"用牙签在鸡蛋羹上面轻轻点出熊猫的基本轮廓","pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_17237
             * .jpg"},{"pcontent":"用纸卷成漏斗形状","pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_44414.jpg"},
             * {"pcontent":"分别装上少许白,黑芝麻在鸡蛋羹上<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160805/114213_73707.jpg"},{"pcontent":"分别装上少许白,黑芝麻在鸡蛋羹上撒出熊猫的图案.<br />\n",
             * "pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_57385.jpg"},{"pcontent":"撒出熊猫的图案.<br 
             * />\n","pic":"http://api.jisuapi.com/recipe/upload/20160805/114213_56249.jpg"},
             * {"pcontent":"最后用香菜做为竹子的形像摆布在熊猫下面.<br />\n","pic":"http://api.jisuapi
             * .com/recipe/upload/20160805/114214_12754.jpg"}]},{"id":"37348","classid":"364",
             * "name":"章鱼炒面便当\u2014你侬我侬","peoplenum":"1-2人","preparetime":"10分钟内","cookingtime":"30分钟-1小时",
             * "content":"从前有一个男孩很爱一个漂亮的女孩，他总是默默的走在女孩后面保护她，女孩的脸上很少看到笑容，她最大的心愿就是想去看海，海离他们太远了，男孩没有足够的钱带心爱的女孩去海边，为了让女孩开心男孩想尽了各种办法，春天终于来了，漫山遍野开满了鲜艳的花儿，男孩也赚到了足够多的钱可以带女孩去海边了，他们看到了两只可爱的章鱼，章鱼先生为了取悦心爱的章鱼小姐亮出了自己的绝活\u2014\u2014中国功夫，章鱼小姐为了吸引章鱼先生翩翩起舞，终于女孩笑了，笑得那么美，男孩依然在女孩的后面默默的保护着她，后来他们过上了幸福的生活。（本故事纯属虚构，如有雷同纯属巧合！哈哈，我现在发现做完便当我脑子里就蹦出故事了）","pic":"http://api.jisuapi.com/recipe/upload/20160720/090358_71168.jpg","tag":"便当,儿童,炒粉","material":[{"mname":"油","type":"0","amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},{"mname":"青菜","type":"0","amount":"100g"},{"mname":"心里美萝卜","type":"0","amount":"50g"},{"mname":"胡萝卜泡菜","type":"0","amount":"50g"},{"mname":"鸡蛋","type":"0","amount":"2个"},{"mname":"蟹肉棒","type":"0","amount":"适量"},{"mname":"生菜","type":"0","amount":"适量"},{"mname":"香肠","type":"0","amount":"100g"},{"mname":"雪梨","type":"0","amount":"250g"},{"mname":"小番茄","type":"0","amount":"20g"},{"mname":"海带","type":"0","amount":"适量"},{"mname":"白醋","type":"0","amount":"适量"},{"mname":"酱油","type":"0","amount":"适量"},{"mname":"熟面条","type":"1","amount":"200g"}],"process":[{"pcontent":"准备好食材。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_88585.jpg"},{"pcontent":"心里美萝卜切薄片用食盐和白醋腌制入味，将青菜切好备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_19074.jpg"},{"pcontent":"香肠对半切开，用刀竖着切至二分之一处成八条。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_74071.jpg"},{"pcontent":"用水将香肠、蟹肉棒、1个鸡蛋、海带煮熟备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_81811.jpg"},{"pcontent":"炒锅油热后倒入蛋液和青菜翻炒。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_97913.jpg"},{"pcontent":"接着放入食盐和酱油炒至7成熟。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112932_33293.jpg"},{"pcontent":"放入熟面条翻炒均匀出锅。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_73866.jpg"},{"pcontent":"将炒面放入便当盒。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_91501.jpg"},{"pcontent":"将煮熟的香肠和蟹肉棒取出，将蟹肉棒打开压出章鱼的眼睛和嘴巴粘在香肠上。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_61147.jpg"},{"pcontent":"用胡萝卜泡菜压出蝴蝶结戴在女章鱼头上。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_57979.jpg"},{"pcontent":"同样用胡萝卜泡菜修成一顶帽子戴在男章鱼头上。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112933_90936.jpg"},{"pcontent":"将胡萝卜泡菜切成花形。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_84362.jpg"},{"pcontent":"用模具在上面打孔。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_20464.jpg"},{"pcontent":"如图打六个孔。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_38830.jpg"},{"pcontent":"腌好的心里美萝卜用模具压出花形。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_57845.jpg"},{"pcontent":"和胡萝卜一样打孔，打出来的小边角料刚好放入胡萝卜的孔里。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112934_79145.jpg"},{"pcontent":"鸡蛋对半切开，用海带压出头发、眼睛分别做成男孩女孩。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112935_10480.jpg"},{"pcontent":"挖球器将梨挖成球状。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112935_12402.jpg"},{"pcontent":"将做好的食物摆在合适位置即可。","pic":"http://api.jisuapi.com/recipe/upload/20160805/112935_35159.jpg"}]},{"id":"39474","classid":"382","name":"粽子---做给我们尊敬的父亲大人","peoplenum":"6人以上","preparetime":"2小时以上","cookingtime":"2小时以上","content":"80多岁的父亲年数已高，今年牙齿也开始脱落了部分，很多东西都嚼不动了，在我的记忆里，父亲极少下厨，只有当妈妈出远门了，无法赶回来做饭，我和弟弟就会扁扁嘴：今天是爸爸煮饭。唉！。。。那顿饭吃得很磨叽，然后端着碗去奶奶那噌菜吃，然而父亲也有杀手锏，父亲最拿手的菜就是：酸菜炒猪大肠。记得十年前，常年在外工作的大哥休息日回家还经常会说：爸爸，明天吃猪大肠咯。 然后父亲就会笑嘻嘻的反问：想吃猪大肠？ 叫你妈妈明天早上买猪大肠回来啊。 妈妈一大早去早市买了猪大肠回来，父亲就开始动工了，父亲是那种慢工磨细活的人，一副猪大肠他需要花一个早上来洗干净，洗到完全没有异味。往往这个时候，我家姐夫就会说：爸，不要洗那么干净，有味道才更好吃呢。父亲从洗猪大肠、酸菜，到炒好，全程不让人帮忙，自己完成，父亲炒的猪大肠爽口不韧，酸甜可口，是父亲唯一做的让我们想念的美味。一个月大概能吃一到2次酸菜炒猪大肠。父亲属于少言寡语，每每我们要求他出手做猪大肠，那天他会特别的开心，被需要是种幸福。后来父亲出了车祸，手脚不灵便了，从此我们再没有吃过酸菜炒猪大肠啦。<br />     过年的时候，我特地买了很多果仁回家，想着父亲无聊时可以吃吃零嘴，才知道父亲牙齿脱落了，已经嚼不动果仁啦，我心里很酸，很惶恐 子欲养而亲不在那感觉一直纠缠着我的思维。把果仁拿去请人磨成粉，这样父亲可以用开水冲来喝，父亲喜欢喝。<br />     我们的奶奶一辈子没有离开过酒和茶，但我们一身书生气的父亲却一辈子烟酒不沾，喜欢吃糕点，呵呵，老人象孩童，这话不假，老父亲就象孩子似的，一天到晚不停地找东西吃。哥哥弟弟回家也会带父亲喜欢的点心，姐姐们离父母近些，她们每周都会给父亲做些小吃送过去，姐姐包的粽子，父亲一次可以吃2个。这个父亲节，女儿不做下酒菜，一起包粽子孝敬我们的父亲，希望父亲身体健康，多享几年儿孙福，父亲节快乐！","pic":"http://api.jisuapi.com/recipe/upload/20160720/092115_58187.jpg","tag":"端午节,粽子,下酒菜","material":[{"mname":"咸蛋黄","type":"0","amount":"适量"},{"mname":"叉烧","type":"0","amount":"400g"},{"mname":"五花肉","type":"0","amount":"500g"},{"mname":"虾米","type":"0","amount":"250g"},{"mname":"油","type":"0","amount":"适量"},{"mname":"生抽","type":"0","amount":"适量"},{"mname":"胡椒粉","type":"0","amount":"适量"},{"mname":"料酒","type":"0","amount":"适量"},{"mname":"南乳","type":"0","amount":"1块"},{"mname":"鸡精","type":"0","amount":"适量"},{"mname":"红葱头","type":"0","amount":"适量"},{"mname":"糯米","type":"1","amount":"1500g"},{"mname":"红豆","type":"1","amount":"500g"}],"process":[{"pcontent":"材料：糯米，红豆，五花肉，叉烧，虾米，咸蛋黄，棕叶，粽篾。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152237_99628.jpg"},{"pcontent":"首先提前一天浸泡粽叶和粽篾，泡软了，在用之前洗净。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_48192.jpg"},{"pcontent":"咸蛋黄用线一开二，切开。<br />\n这是自家提22天腌制的咸蛋黄，又香又油，我们是一个粽子半个咸蛋黄，可按个人喜好切分。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_40164.jpg"},{"pcontent":"叉烧切块，备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_68166.jpg"},{"pcontent":"红豆隔天晚上浸泡，用之前洗净。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152238_55492.jpg"},{"pcontent":"糯米提前1小时左右浸泡，洗净。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_92870.jpg"},{"pcontent":"浸泡洗净的糯米。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_48090.jpg"},{"pcontent":"洗净的糯米和红豆","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_26905.jpg"},{"pcontent":"糯米，红豆放点油和适量盐和生抽，调味 拌匀。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152239_80958.jpg"},{"pcontent":"五花肉切块","pic":"http://api.jisuapi.com/recipe/upload/20160805/152240_53079.jpg"},{"pcontent":"红葱头剁碎","pic":"http://api.jisuapi.com/recipe/upload/20160805/152240_88392.jpg"},{"pcontent":"调料：料酒，胡椒粉，四季酱，南乳，鸡精，盐。生抽。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_10913.jpg"},{"pcontent":"热油锅爆香红葱蓉，放点盐一起爆香","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_47707.jpg"},{"pcontent":"放入五花肉，放南乳。。。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_21948.jpg"},{"pcontent":"放四季酱，料酒，胡椒粉，南乳，鸡精。生抽。翻炒","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_12548.jpg"},{"pcontent":"不停翻炒","pic":"http://api.jisuapi.com/recipe/upload/20160805/152241_55683.jpg"},{"pcontent":"翻炒到五花肉均匀沾上酱汁 翻炒至变色即可。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152242_89560.jpg"},{"pcontent":"放了调料翻炒过多五花肉，很香的","pic":"http://api.jisuapi.com/recipe/upload/20160805/152242_72744.jpg"},{"pcontent":"虾米放锅里炒香 盛出备用。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152242_93883.jpg"},{"pcontent":"都准备好了 要开始包粽子啦","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_57258.jpg"},{"pcontent":"2-3片粽叶先对弯成漏斗形，抓一把糯米，然后依次放近五花肉、叉烧，虾米，半个咸蛋黄，再抓一把糯米红豆覆盖在上面，把上面的粽叶往下覆盖，捻紧折向一边，包成一个四角的粽子，然后用泡软洗净的粽篾帮紧，OK.","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_54890.jpg"},{"pcontent":"包好的粽子 4个不对称的角组成。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_89182.jpg"},{"pcontent":"粽子","pic":"http://api.jisuapi.com/recipe/upload/20160805/152243_86032.jpg"},{"pcontent":"包好的粽子 开水下锅，","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_88909.jpg"},{"pcontent":"大火煲1.5小时关火 虚火3-5分钟<br />\n姐姐说高压锅压没那么好吃，所以选择这个锅慢慢煲。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_51118.jpg"},{"pcontent":"煲好的粽子 要提起 不要一直浸泡在锅里，挂起来，这样可以保存的时间更长些。","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_35404.jpg"},{"pcontent":"漂亮又好吃的大肉咸蛋粽 ","pic":"http://api.jisuapi.com/recipe/upload/20160805/152244_69183.jpg"}]},{"id":"53517","classid":"586","name":"我的爸爸饭团","peoplenum":"1-2人","preparetime":"10分钟内","cookingtime":"30分钟-1小时","content":"辰辰是个很喜欢画画的孩子，于是本子上，我们家的墙上到处都是辰辰的大作，今天这一幅我的爸爸就是来自于我家墙上辰辰的大作，周日就是父亲节了，想着做个跟父亲有关的美食，找了一些图片后我就想起辰辰也画了好多爸爸啊，何不把辰辰心目中的爸爸做出来，这也算是一份比较特别的父亲节礼物吧，爸爸在辰辰心目中是穿着铮亮的皮鞋，提着一个大大的包，大大的肚子，长长的胳膊长长的腿，只是竟然木长头发呢，爸爸在孩子心目中的形象总是千奇百怪的，记得小时候老师布置的作文有我的爸爸，每次也都会天马行空的乱写一通，爸爸就像一座房子为我们遮风挡雨，爸爸就像一棵大树伟岸挺拔，爸爸是一盏灯，坚定不移，永远引导我驶入安全的港湾;爸爸是一座知识宝库，挖掘不尽，甘愿为我解难答疑。<br />　　有一次忘了在说什么了，辰辰问谁啊？我说你爹，辰辰问啥是爹啊？我说爸爸就是爹，从那以后辰辰有事没事就管她爸爸叫爹，爹，你在干嘛？爹，我叫你为啥不答应？还跟我说：娘，我爹咋不理我呢？我说你爹忙着呢，辰爸每天都很忙，辰辰希望爸爸可以经常陪她玩，可是爸爸要为了她美好的未来努力工作，辰辰想像爸爸一样会开车，像爸爸一样去工作，辰辰内心是很崇拜爸爸的，周日就父亲节了，祝辰辰的爸和辰辰的老爷节日快乐！","pic":"http://api.jisuapi.com/recipe/upload/20160720/121831_52717.jpg","tag":"儿童,创意菜,午餐,父亲节","material":[{"mname":"油","type":"0","amount":"适量"},{"mname":"盐","type":"0","amount":"适量"},{"mname":"海苔","type":"0","amount":"适量"},{"mname":"虾皮粉","type":"0","amount":"适量"},{"mname":"番茄酱","type":"0","amount":"适量"},{"mname":"生菜","type":"0","amount":"适量"},{"mname":"熟鹌鹑蛋","type":"0","amount":"适量"},{"mname":"米饭","type":"1","amount":"150g"},{"mname":"奶酪片","type":"1","amount":"2片"},{"mname":"西兰花","type":"1","amount":"50g"}],"process":[{"pcontent":"准备好食材。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142614_26205.jpg"},{"pcontent":"将米饭和番茄酱一起拌匀。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_55066.jpg"},{"pcontent":"米饭用保鲜膜团出头部。<br />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_66499.jpg"},{"pcontent":"继续团出身体用生菜叶包住。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_98789.jpg"},{"pcontent":"鹌鹑蛋切掉顶端做眼睛。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_83395.jpg"},{"pcontent":"海苔做嘴巴和眼睛，生菜在包两个长条米饭做胳膊。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_57330.jpg"},{"pcontent":"炒锅油热后放入西兰花翻炒片刻，加少许食盐、水、虾皮粉炒熟出锅。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142615_79528.jpg"},{"pcontent":"奶酪片、海苔做出裤子、领带，宝宝、鞋子等。<br />\n<br />\n<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160722/142616_94653.jpg"}]}]
             */

            private String num;
            private List<ListBean> list;

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * id : 16842
                 * classid : 133
                 * name : 芒果冰激凌—夏天里我最喜欢的水果味
                 * peoplenum : 5-6人
                 * preparetime : 10分钟内
                 * cookingtime : 2小时以上
                 * content : 夏天怎么能少的了自己在家做的冰激凌呢，有了草莓的，抹茶的，可我最爱的水果就是芒果了，怎么又能少了芒果冰激凌呢！自己在家做的卫生有好吃，芒果味十足，降温的好甜品o !
                 * pic : http://api.jisuapi.com/recipe/upload/20160719/154535_26015.jpg
                 * tag : 儿童,冰品,冰淇淋,白领
                 * material : [{"mname":"细砂糖","type":"0","amount":"150g"},{"mname":"盐","type":"0","amount":"2g"},
                 * {"mname":"蛋黄","type":"1","amount":"3个"},{"mname":"芒果泥","type":"1","amount":"300g"},
                 * {"mname":"动物性淡奶油","type":"1","amount":"250ml"},{"mname":"牛奶","type":"1","amount":"380ml"}]
                 * process : [{"pcontent":"准备好所有材料。<br />\n<br />\n<br />\n","pic":"http://api.jisuapi
                 * .com/recipe/upload/20160802/102249_17398.jpg"},{"pcontent":"3个蛋黄，细砂糖，盐，牛奶倒入小锅搅拌均匀。<br />\n",
                 * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102249_89239.jpg"},
                 * {"pcontent":"小火加热奶锅并不断搅拌，直到沸腾立即离火，放到一边冷却。<br />\n","pic":"http://api.jisuapi
                 * .com/recipe/upload/20160802/102249_27040.jpg"},{"pcontent":"芒果去皮打成芒果泥，多打一会，这样出来的果肉细腻。<br />\n<br 
                 * />\n","pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_85095.jpg"},
                 * {"pcontent":"冷却后的蛋奶液，加入打好的芒果泥。<br />\n<br />\n","pic":"http://api.jisuapi
                 * .com/recipe/upload/20160802/102250_36477.jpg"},{"pcontent":"芒果泥和蛋奶液搅拌均匀。<br />\n<br />\n",
                 * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_32367.jpg"},
                 * {"pcontent":"淡奶油用打蛋器打发至6，7分。<br />\n","pic":"http://api.jisuapi
                 * .com/recipe/upload/20160802/102250_10602.jpg"},{"pcontent":"芒果蛋奶液加入淡奶油里。<br />\n<br />\n",
                 * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102250_58489.jpg"},
                 * {"pcontent":"搅拌均匀成冰激凌液，放入冰箱冷冻。<br />\n<br />\n","pic":"http://api.jisuapi
                 * .com/recipe/upload/20160802/102251_77098.jpg"},
                 * {"pcontent":"冰淇淋液冷冻到结冰，取出来用电动打蛋器搅一会，再放入冰箱冷冻。之后每隔半个小时取出来搅打一次。重复搅打4次以上，将冰激凌冻硬就做好了。<br />\n",
                 * "pic":"http://api.jisuapi.com/recipe/upload/20160802/102251_97027.jpg"}]
                 */

                private String id;
                private String classid;
                private String name;
                private String peoplenum;
                private String preparetime;
                private String cookingtime;
                private String content;
                private String pic;
                private String tag;
                private List<MaterialBean> material;
                private List<ProcessBean> process;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getClassid() {
                    return classid;
                }

                public void setClassid(String classid) {
                    this.classid = classid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPeoplenum() {
                    return peoplenum;
                }

                public void setPeoplenum(String peoplenum) {
                    this.peoplenum = peoplenum;
                }

                public String getPreparetime() {
                    return preparetime;
                }

                public void setPreparetime(String preparetime) {
                    this.preparetime = preparetime;
                }

                public String getCookingtime() {
                    return cookingtime;
                }

                public void setCookingtime(String cookingtime) {
                    this.cookingtime = cookingtime;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public List<MaterialBean> getMaterial() {
                    return material;
                }

                public void setMaterial(List<MaterialBean> material) {
                    this.material = material;
                }

                public List<ProcessBean> getProcess() {
                    return process;
                }

                public void setProcess(List<ProcessBean> process) {
                    this.process = process;
                }

                public static class MaterialBean {
                    /**
                     * mname : 细砂糖
                     * type : 0
                     * amount : 150g
                     */

                    private String mname;
                    private String type;
                    private String amount;

                    public String getMname() {
                        return mname;
                    }

                    public void setMname(String mname) {
                        this.mname = mname;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getAmount() {
                        return amount;
                    }

                    public void setAmount(String amount) {
                        this.amount = amount;
                    }
                }

                public static class ProcessBean {
                    /**
                     * pcontent : 准备好所有材料。<br />
                     <br />
                     <br />

                     * pic : http://api.jisuapi.com/recipe/upload/20160802/102249_17398.jpg
                     */

                    private String pcontent;
                    private String pic;

                    public String getPcontent() {
                        return pcontent;
                    }

                    public void setPcontent(String pcontent) {
                        this.pcontent = pcontent;
                    }

                    public String getPic() {
                        return pic;
                    }

                    public void setPic(String pic) {
                        this.pic = pic;
                    }
                }
            }
        }
    }
}
//jhfghfh
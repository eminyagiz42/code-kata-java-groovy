package com.codekata.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemovingStars {

    private static final char STAR_SYMBOL = '*';

    public static void main(String[] args) {

        // https://leetcode.com/problems/removing-stars-from-a-string

        String s0 = "u*ensso****x*q";
        String s1 = "erase*****"; // output ""
        String s2 =  "leet**cod*e"; // output "lecoe"
        //output ornyvoivdjlcbebvvooiljtrxqivumuprpervlwxpatylutcbthxpjufriunjuhfqosuqbeeilqzuzmwkwskcgktphwawpisaqmusdafyzcoqgvlhznnsutjdc
        String s = "t*av**trbi***p**lx*romh*lb*p*d**r*ngiap**h*****lvol*ws***b**b**kf***bu**wa*v***m**cs**k*rv*fql*" +
                "qgz*l*cbm***tzyy**h*m*y******tp****dkc**qn*n*plxw***bsz*g*xo*w**o***drzyed*k*ghkhtdjcv**cq**z**per" +
                "eh*nbc*a*****w*bz***f*g****h**yj****v*k*u*bqfo*wl****i**tygp*kd*****n****bh**vg**lkhqd**o*jb**l*lc" +
                "*r**a****uaow**en*a**o**b*fnfzk******uygbo**s***l****n**u**db*i****v*n*vr*h**alx*gxivil*oz*****r*t" +
                "t*wc*wfsyvn***d*****av*muivdw*rgc*t***f*jk*gp**vh*u***mp*w**rum*bm*kimd***rv**gcolj*buzosal*f*b*yl" +
                "mm*aohep*****lc*e*r*po*v*t*bo**j*w***vo***ft**z*h**w**if*ql*p*o*odcp*t**y****u*n**krzq*zpi***l***c" +
                "zo*r***y*rf*slz*****d***gh**j*q*t**bjsgzh*d*t***j****i*qk****u**m*rj*xwas*r**i*pk*k*z***p*o**z**p*" +
                "d*zm*crd**mtyn*t*kd**n****drk*i*****j*****c**ri***x*pj**e*k**py*spcir***mu*zg******bru**myk***ty*d" +
                "f*v**wwcd*s*itdvse*t**w*b**k*t*r******vs**ep*c*o**rb*k*w*x***h***krw*zm*n***ag****f*oq*gcu****wu**" +
                "g*lunwr*yptwo**ck*q**s*wzsz*l**tkfm***p*lj*v**rhw*re*t***b*o*wwmkzeyluw**hv**vj*f***f**j*tj*gzpy**" +
                "*oaf***z**k**h**sfmyn*iipg*jq*j*w******uf*v**v*z*sf*b**t**fmkg**bv*****p*i*ta**xm*yxy**rnzi**i**i*" +
                "vn*x*dbgk**mres**ci*a*p****j**oh****b**j*v***krzgq*q*c******nn*l**t*a*s*r*dm***v***u**rzht*afhis*e" +
                "rfl*p***svx*****v*u***v***u*w****e*ri***i*ihhac*l*f**p*evu*vp**jpxz*p**ox**y***w*sf**kz**l**z*flfg" +
                "**m*ba*wfli*****h**y**un*fzn*h**g**hb****b*h**g*s*h**z*nxzo*o***f*****xy********sa*th*d*lbbas*joh*" +
                "**wc*j***mr*kx*sjw*gztrz**qmbg***ar****d****hahj***bhz**vs**kp****p*sv*****k*dy*******v*p*tv**ax*p" +
                "******msfp****l******eu***r*wt**vd*iy*neei*vs***nl***oey***vwa*e*zh*a**une*w*********o**ly*w*u**lw" +
                "***mi*s**g*wbh**i**n*pymv*bk*kb*njww***iq**e***i*jgip***y*cz**lyp*g*d*a*we*dl**mz**w**cy*vh*k*j*io" +
                "*m****z*th*w*rod**jg***dn*y***pt***mcaq*cm**qlj****v*o**wk***fa****a*h***gsrf*o*d**b**j****w*yte*o" +
                "h*q**eg*y*a**r*d*i*z*z**qae**x**f**dj**f*m*i*f*t*va*ojp****giv**f*xr**k*j**nhulev**pu*n*b*w****j*v" +
                "a****b*grtdsx*f**m***hwlh**r*z*y*q*bz*iraqxv*ul**m*sxl*nx*be*r*****m**rih*m*im*vl**lf***kp*wg*****" +
                "**l*k*jj****g***e**y***qa**aie*ey*elb**i**w**dxy**f*o*i*u**ba****igfwqvbv**b***ryc**av*x*hc*r*nzcx" +
                "*******t**wx**b****xjs*aw*ty**k*h**kb*cexr**v*****pgsod*fb**i***rgoglk*x***h****ok**t*qbp*j*b*cy*w" +
                "**libxn**f**vy*rlyv*lk***f*u***n***so***c*ba*xc*q**e**ece***t*pyogtazs*na*k*g**tus***d****m*******" +
                "*km*wx*q*b*be*y**p*u*o*eky*m*v*t**x*o*l*ug****c*ad**nf*m*xj***g****ru*u*idoj****qc*ihsqvnrfpqi*u**" +
                "*lge*ab***r*er***cl*ne****a*u**g***f**ry*q***s*q**x****dizydv*z*zaa*io***c*cc*bu**i*v**y***e*i*nyj" +
                "****btfi****nui*kof**d*buz**n*****gy*y*et***m*g*y****gg*qmh*s*hor*****b*o*yn**i**rbp*n***p*po*cv**" +
                "*dtqyv****lvago*y*h***o*bopj**g*o*hapm*oq*o**k*k***x****l*y*oebx*hu*f*xu******l*h**y**o**hth*krt*i" +
                "n*y*y*t*r*s**qxp***noy*lx*p**swd***j*sw*v**hndm**eyw*msre*ut*yd*k**l**l*b*w*u***pq*jhr*ngjmxekdb*p" +
                "iwh**e***bm**i*ic**f*gv*x*n*****qmn**vwe**j***veyyyjjyw***vj*i*czg**d**c***bwico**c**tz***lx*u**s*" +
                "*d********t*is**nv*r*rcqm*hgan****d***ok**j*q**mrt**s*****u**h*z*i*h**fz*i*r**z***l*o**b****w*a*eg" +
                "*nu*hp*i**itm****x**r*p**p****a**ux*vl*phl****i*o*hu*o*c*i**y***kc*bc***ddzh*iuye*******efas*bju*g" +
                "c*b*nuzz*t*y**d**nvir**o**qo****xo***x*y*alx*mdw*aa***hm*n**l***o*r**pen*pg*a**q*****o*e**jgd*axwn" +
                "**vg**fx*y**r*i***i***vkajbo*duc*y****kw******w**t**t*i*a*t**o*h*f*z*h*d*c*ia*j**urj***i*sr*a**rsv" +
                "**nfzvt*d*w*f*tk***b*p**f**zgajc*cr*b*l*pf*q**qqfs*zte**sh***i***du*umpe***qlsl***lg*zwu*****lmw**" +
                "v**rfee******s**hkc***e**y*iry*j**kyx**dx*k*wqzi*e*****m*****cfj*q*ae****z*jczm**dd*****b*lw***oh*" +
                "**k**acru****n*il**yx**gz*l**k*ufrc*x**s***x*l*t*w*j*t*wkt*fgbwu*un*zw**uryv*vp******xnke*x****p*h" +
                "a*m****wu**o*vc*qa*n**f***i*l*pk****sh*aw*h*q*db**j*d*iirnij*f**bew***tqx*e**gq***tu***o*bhn**zr*x" +
                "deoi*c***a*ofu*btr****i**lfc**uk*z*mvnzmk*uh*l****j**l**yvqoczv**v***cpu*fbx**r*k******bhkv*b**y**" +
                "*r**s**nt*ir*d*g**kwnae***w*b**s**avryv*c***v**er**aq**el*fu***nt*vxx*rt**zeljf****ka******nb*gfw*" +
                "**pscfvtf**ug**jp***goo*r*****pq*we**ukb*x*hmn***aurrzj*ezfo*****ok**mmg**z*qkz***yl*h****f*x**i*n" +
                "*et*t*b******vj*p**sm**ly***y**uphjhv*c*aa**m***ecjr*ub**qovp**e**n*g****f*jw****lcmtxz*s*u****wtn" +
                "*o*hvmf*v**c****j*o***d**ci*ilp**b*a**kh**ui**i*od*k****bw****qc*qtc*q****ia**s***w***u*r*****y*pe" +
                "**vx***v**ge**n**zws*p**b**elb*q***u*zts**q***ei*w***y*yhdg*eo*afrz****b*****d*uz*g***p**n*q*v*xfw" +
                "**dvfd*m****re**gf*ba*b*rb****fcz****d*m*ini*i*h**w*gq*bk*dfc*j*g**g*no*p***pq*f*****pm**apj*pvscz" +
                "uil*d*ja*bp****r**o*v*k***piqic*fa***pftv*el*x*z**gm*lgxj*qemc**q****k********qwmxexwrxu****tm****" +
                "*i***n**fdn**qs*k*m***u*mr*****m*****p*wtdfw**z*h*y*m**v***ov*lw**rnyvv*ozsm**cau*u**y*wq**o*c***u" +
                "y**irvsb*v*rxtkzi***avci*sr*p*s**rzs*k***f**wa****iz**xvk*h****uhc**iq***cw*is**j*dmc****ojjf*dan*" +
                "*fukbqp***z**nk**xp*******n*******vdjlcbj*ep*xpo***bvu*km**hm*l**yt*bs**xu**v**cgb**kyit**m*y****v" +
                "owv*rr**v**w*c*ii*q*y*xraos*****mvhxfukjy**wa**ok*c*alfx*h*bcy*t***b***a*r*qtpu***nim**t***bzpo***" +
                "tq*j*l*nhr****e**mtrvlq*w*xld*ka*k*fye*x*p***z***wi*eu*wr*****kn**b****ok*ho*y*a****l*y*lq**go*mc*" +
                "zx**njrh*d**epefz*k*ce*n**x**lera*kmudr***qs**x*i*pla**u*t*p*d*b*l****j*xw*z**y**s*s*dvorf*n**k***" +
                "*j*cm****i*rs**g*seouvm**q**f**vdd**yers*w*u*ishc*v****lu*q**y**u*lgdzd**z**pge**rd*a*xypuv*osx*m*" +
                "q***o**naxmp*xs**z*uljvi***zj*********kw*****gm*ki*q***s*tw*ky**py*duk***q*q*f*gh***nz**gbd****mu*" +
                "gfg****r*xgbe*uhozi**p*nw*qo*cs**g*g**xiv**c**h*yk*k*f*jj*****kumg*w*tu*ats**a***qo*y*g*fsiyt****k" +
                "*a*m*to*p**if***u**n*mo*z**ouj*jy*fy*h**pmxk*f**m**ba*rk*f**uaxkfuq*w*****q*****zj**k**rerr**j*o*t" +
                "h*kl******o*x*xs*n*kjmpd*h*l***wh**dk***knrk***c*a*pu***h*yz*wvz*p**b**li*tb*sj*rrs**t*gbw**a*fgoy" +
                "odu***o****wxx*n**z*tx*r*****urq*q*oz***zsly*f****q*ue***fi***mgg*t*zlppa***gf*x***y*g**l**we*h*od" +
                "*c**l*r***x**ze**j*e**zyhfrn****w*dugm*r**m***tvx*fy*nqwr***n***cumipe*j*o*shoa**lw*y*****mgg*q***" +
                "*o****v*****o*bt**a*aw*l****v***brskjpy*n*m*h**q****f**m***fti**ow*****e**snlo**m****v*f*kjthc****" +
                "*rci*s*rn*eay*q**uvxtl**t**u**r*j*q**bqos*xe*s*sx**ih*o*y*kirhs**ny*xxahz**lh**m*fwdi*ctn**qu**gt*" +
                "***i*iaa*m*iaa*h*pr*or*jg*****f**n*p*r**n*s**n**l***zzh****s**qc*uyou*g****d*****c*g******t******c" +
                "ojve***b***is*v***r**y*w*g***tp**wsqop**cz*l*m***o**tu*****q**laf****xbr*hctm***awoc**ha**omj*h*lc" +
                "***nr***q**ouxq*rr*txjlba***gj*vt**luhr******i*g*sd***k*d*cq*tzw*fh**x*a*aokb*b****z**luc*pi*t***k" +
                "**uwtjr*g*xt**rm***f****h*cph*z**oa**kfg*e*utv*wrgr***lub*xpvd*upjduar**zs**r**jdh*hh**vd****gqe*r" +
                "*q**ists***vn**v*****s****g*tjyur***y******m******zi***pjvim*b*my**uy*ea*y**a**rydz*wd**fuf*j***y*" +
                "***n*yfx*dly*auv*lic*dc***e*cs*n*l*ld*qc*g****rq*yk*j*zkugy**bd***m*****f**h*ojexd*e*j**d*a**nmp**" +
                "*s****x*s*rj*t*kb*j***h***xu**h*bpdfr*****j**q**m**h**jg*ypp******rb***n**yok**u*hm*u*o*d****ab**o" +
                "ayd*ofagc*hikeg*y**sx***l*ak*sw*e*m*******l*c*n*m*lh***rzfif**e**j**w*d***d*hru*o*z***q**n*pvez*em" +
                "qru*h*ld****kt*fgk***v**z**t*u*rx***krwgcl****o**f***t*co***w*hp*vqpcda**q*eo*******tay**rqk**k*v*" +
                "lxdb***flh*s*zlvwpqayt***tvp*ytc**f***fr*v*a****nsmp*nqmhck***ma*nx**l*br**fh**n*u*qjtt*esq**v**ur" +
                "uoa*l**p***d***ommg*z***p**r*pd*iv**tkad*vp*va**a*qj**af*qw*la**qbj**tw*m**va**y*****u**ogahx*r***" +
                "*y**r*wv*tpo**vkrs*sb**cmw*t***vp**d*ef*s*hlm*bg*ln*bf***lx*****f*eu*e*t*k*cz*ts*n*sbrvz*g**nt*n**" +
                "**tpab*k******ljzve****jvrd**e*fo****n**cx*q*p*irydm*gbmauad*bl*zg*v**bkl**p*i*a*oz**x*u***b**pk**" +
                "ne***gu***q*x*b**cf*ud**h******c**y*rhu*gl***egiz*qv*qm*f**gcs****e********x*d*cwa**rl**jr*jw*c*u*" +
                "*in******dph*m**m*g*****z*t*fjuot**x*cj*n*q*p**i*g**h**elzw***bln*t*v***yfok*******a******nm***x**" +
                "*hd*y**xj**mue*w*orw***z*****duj**df*qvd*o*h**da**gf*j*****gxqk*ik*k*v**y***g**t*******j*t**u*jb**" +
                "ng*u****q*ax***u***wg*jga***l***n****wzj**is**vof*w*uz*o*ej*****qktay****e*x*llkh***j*l*fx*b******" +
                "******k*p**od*ro*zowm*vvs**b*p**c**l***yjlg**ere**iwrx***elz*iekk*ghwl**d*r***h**y*w*j******c*x**i" +
                "aktc*go*ib*sl*y*u*********b*j**vh***b*****exv**m**n*i*m*fcr**ol*s**zr**w*n****y**e********i*yj*th*" +
                "h***ohx**p**e*x*g*gusju**v*k********vs***m*rd**ss*d*dk***e*bx**dp*hew***vl*y**v*rpjxs*x*cv*m***orj" +
                "x**bo***r*zeafe****jbr*****houje*zi*h****o**c*****g**y*fx*ll*al**s*p**t*hww*l****e*h***ujf*x***t**" +
                "m*jxelhq*a*c*y*wylx****ojt*v*hhg*okr***jozb**fv*i****p****u**msiz*ax**fj*s*a*ay*qdy*o*h***gnq*wi**" +
                "*wks**p**cg**x**ggq**b**yd*j*d**j**h*az***ty*tb*s*qfu****k*waw**j***qodhx****d*f*yh*vczmn**d**ywc*" +
                "*lndm*c*a***f**l******qx**s*fn*k*d*******q***l*m*z****n**oiljam**rq**trvk**xqa*t*is**ivumd*uy*h*pr" +
                "pempk**n**z*wo**rvsv*t**li*wmzqm*vaozk***w*t**qzeullo*c******yrn*abrhzivo*egh****p*uax**qqqk**w*mn" +
                "****g**sazhpomi*eawz*v*n*u*qf*dj**y****t*nhdrg**f*l***q****pnqh******u*iw*te**fq**bikt*i*y*z****ws" +
                "***o*sg*fqc*q**eq*u**u*z*ja******fs****q*v**zac*ct*kc***l*umu*jn*cb*h*o**rale*wac*itc*jwxc****wy*i" +
                "hv*gawa*kk********yi*awym*****qs*roswn*j*mg*h*uub**ddg******n***d*m*mv*q*x*m*flmjpx**yhd*lz****pq*" +
                "ne****x*x*u*m******fkx**cf***di***m****o******xqpfh******e*i**y*****n*w*o*p*f*v*mr**wtc*p**z*y****" +
                "**mg**b*roc*d*t*jy*pg*****s*ze*vd**t****dh*jeh*ay*ym*y*f**q*l*v**zp*c**j***y****b*d**l**xlxo***r*p" +
                "atyluh*tcbtoo*ii*m*srq**o*s**ujp*hufmjjfc*rvd**b**d*ru*i****rz**x**rq*jxa**klo**f**sae*xb**dpxv**r" +
                "*c*a*f**e*u*aqq**a***rw**zz**rr*xqr***crtt**xl**sbi*******x**g*usq**wd**xhm*lr*tq*q**jnp*wq*em**tq" +
                "atf***abo****cv*r*o**s****t****lc*e**yok**eecp**cl*o**m*aueb*mu*s**h*hhk*w*x*ec*****t*****zxo*v***" +
                "***g**icpx*fofrj*j**m*q******wzt*th***runc*u*rc*ds***s**u*m**s***q*p*dwyv***z******gz*****r**o*k*m" +
                "*l**c**hkq**xpjr*uv*frihn**ur*njhey*sy*hqndhlipl*bvzvm****ii**a*****o*s**ch*vx**p*fjp*r*vpe**l****" +
                "*cmlux*k*******gbxk*qk***p*a*****yq*pu**fko*vc*i*****v**ur*nr*j***z*g*x*c***uh*n*cz*gm****uhfo*e*w" +
                "*z*yi*ap*d*gj*xr*uw*fvz*yn**r**rdu**lk**a***k*****t*x**qosj*uqbeeilqndn**a**s*zuf*zmwsol**grkzoq*k" +
                "***ga****dd**l*dcdhr*l******u**kqa*d*y*k*u**rbv**u*go**m**b*wsswjh*v*ftv***uu*dq***utmwsl**yhfh*bm" +
                "yn**mfou**ilsw**xc**l**u*ht**we***k***zb**wf*top**zk***t*cv*t***k*sf*tmr***ax*gf**wj**t****fcu*iij" +
                "wn*ock*enho*u***e**q*r****p**vhe*whvf*zqmzmj*wbxv*bk*k*v**e*p****dmpb***hpif*n******z*fgg**bspd***" +
                "p**m*yl*htqa*wp*u**h***aptqv****v**l**x****f*bu***j*d*u**o*fl*jihs*vc*vo**z**s*lqaa****yom*gwldrqt" +
                "***i*t*p***r**ny*****auzcv**f******sg****ro****u**x*b***v*kbx*p**hs*nf*o*****e*b*rwe**vgby**krhd**" +
                "dj**mbq**pa***i**ypggc*****m*p*b*fqqelzt***jgz****f*y*w**h*g*q**x**rl*x***b*r*uwy*******y**u*n*vr*" +
                "v*wjx***akype*lufidd*y*r*s***ww***oolhrwwmr*gh**dx*lishogt*r**fk*x******h*ne********u***r*s*mc**rv" +
                "go*u**y*w*fa**dki*kbkim*rd***k*xl*hi*a***idl*yqv*****g***ip**f**wxkxmx****z***mbf***b*x*d*ll*i***z" +
                "jvf***ars*m***sxia*z**rhw*r*ksy****h***u****w*sg**zjthn**ek***l*iu*bzp*an*****h*jq*uc*****v**oeg**" +
                "i*nzpzi*k*m*o***oz**s*o***az**n*n*ekpxu*****cl*lmopi**t*c*b*s*djsoi***n**l****sf*l*****ed*k*kg****" +
                "***d****cit*v**c**a***a*s*yr*kmzq**o*q*vnm*g*xwwr*qm***epugud**ynwk*i*xt**kth***bm***jut**h***hrar" +
                "v**qjuw*gjk****zut*v*zbo*e**e*qzrkkl*a***a**qbwr****gg**g*d*n*g**jj*****e*l*s*b******kac*t***c**i*" +
                "k**x***c**zbf*ytu***z***j****n***r**h**et*****rc**jktvf***op*a*wsoj***z*xd***r*r**pm*m*eg*hp*xns*q" +
                "**n*heb*du***g*b**meby*jzt***ae***vlsb****atv**h**z*wmon*u*m*bugap***hpjdl**k****iww***uo***ws*kqa" +
                "n***e***api**q*nr***xm*x**fc*ffww***hneyq*z********osvl**qg*f******h*jf*mxpla*a*lga*ic**t*wn*z*z**" +
                "*t*b**i*q*u***a*m***fm*******n*imi****tzj*x**l*e**z**h*y***ito*u**ji***g**h*qgpt*x*z*rbo**ow*c****" +
                "*ei*sadd*u*gs******b*zkt***h**zqz*er*nh***v*pbe**hd*dm*p*b**qck****rm*****j***mkqm**o*xywptco*qf**" +
                "**twv****cz*o*sf***tmp****tgf******vrybbg*k**f*rxx*aj*m**ytc*l**k*cs*lj*f*jhp**s*eq**hhv*****u****" +
                "hut*iciu**l**j***hprr***o*j*****pw**vjzr******n*yo*zzyuez*g***p*k***oqszlt***s****z**q**a*sr*w*x**" +
                "*rlxnu*tbdnm*y***c****vr*l***x**i****mf*hp****tt*sf**hw**r***y*jf*md*a*j*ti***s*q*m**sm*o*e***g*bj" +
                "r*qn*d*sm*f***snlda*vnsu**n*l*yrbe**xei*g**nt**qbn*efpkx**gr*d********kcmpolshvp*mj*fp****mpocofx*" +
                "***net**h*b**w***e*z*rbraa*b**k**jq*****e*k*on******f**ob*o*a*****e*w*py*s**vy*naxm*ln***w*j***j*r" +
                "*s*mrdpp*b*f*no*he**mkuxm*xb*xkkr******lehbw*pb*dr**c*ag**kt*ta**n***h**ss*m***wxh*o*w*c**sf****g*" +
                "*ex*x*****rvhqs*md**zuf*en*jdpu*x*n**ux*wjh*qez*u*pb*cpszdwz***rx*uuc***a*h***t**a*l*rf*t*qa**c***" +
                "**g*gt*ez*p*x*******saw*lx**cualp*nq**zv*o*iv*u*tupa*f***fw*kf***wxgvgdeo***h*d**fge******m*q**bh*" +
                "q***a*ouz***xf*vh*******nep*n*nze*y**ls****o**cn***thwit**h**dr*j****p*i***lzil****fcah*m*yu**f*s*" +
                "jo**k***i**q*t***r**u**b**qm*hn**f*h*vajgc*ljo***ms**da***mv**qo*tf*mq***r****rtssp*u*q****dse**mb" +
                "*smqdsq*d*eus*kte**u****nm*me*k*c***vysnhjr*j*y**k*r********l**xk****je*x**n**z*u**ix*n*a**c****hh" +
                "o***lx****h*s**l*w*mrrp*lniwonnf*c*lldx*et****v**ul*o***s****d*hk**tzz**zvd*s***n*e**cnh*cm*d**tm*" +
                "*m*gj*is**b*to*w**z**tc**p***gi**k*njk**ei*s*i**i*ui**n****z*bn*d*jn****fw***rgo*nf*mdlw*nw**luc**" +
                "fjv***h*jey*b*o**j*f*fkbzhb*m***l**au*sh**a***gwkj***z*****g**pl*xm**ob**q*dj*ju*****q*******sj*pf" +
                "e***i*z*qdlc*xnke*cloc*ml**g**vcsz*****i**gy**fv*r***qfq*g*********a****y**wjurwanhenkeq**et**o**s" +
                "*vj**i*****q**vd**u*fh***j*s**rm*lcsytd*****jwnju*gyyl*bl**km***d****x**x**tv*****q*te***g**px**bp" +
                "**kch****wrxs*******yxze*****y**t**g****mro*lc**x*ai*wov*qfu*****c*hc**t*dxahing*lw*p**c**x****fwk" +
                "**l*h*m****rjt**q*u*d**dv**ci*j***v*nr*m*uhx*jvu**b**m*f**hz***o*ro****h*p*m*knxldlusx**n**k******" +
                "u*o*d*s*af***zz***ktb**xi******j****q*da****t***h*i***ewd*w*jwtv**n*ca******bhe**i**kcv*gp*ky*tpc*" +
                "md*gzj**j**ro*q**j**hncety**vu****w*p**wav*y*wwcx*hiqy***q*r**x*ft*vzne***deavb*c**pi***y*yy*g**q*" +
                "*evj**m****j*s*kyx*ha*hc*****j****pm**phr*tdbtju*bg**bh**xtvk*r*d**f*dvw**gi***c*g**a*hdhfl*m**cz*" +
                "ni*v***cc*fz**tw*onh*bealj****y***py**iztequ*cc*dq*k*soj*j*bjmt****mf*dw**yub*******boi**ym**b**ra" +
                "o*uppd****fe*x*txykxt*****jclpw***f*f*w***p*l*a*******ed*hdzrj*y*tlhget*c**wgo*zulb*o*****o****tzi" +
                "**qt*pl**a**kkcvn******d*bu*m**ukpy**rx*i*fl*ur**j*cv*mayb**f**m**b****cnn**orxw*h*****fg*di*t**sz" +
                "**s*kt**r****g**x*vq**g***daunkv*xy***l**dcypwh*qm*a*t****y**oj*p******gq*kv**wa**x****nm******h*l" +
                "z***fpr****d*yc*vf*nj*bt*igt**jui**u******h*k**y**nj**f***a****s**ss**s*y*cjp**w*a**dyn**f*z**qkn*" +
                "wh**y**kgj**nqil*****s**qf**t*****h***wb*fs*raqt*tina*mq****bljots*o***rabf*****vo**rc*h***dyv*p*v" +
                "***e*****qoiws*zuhe*wg*x***so**dmgujl*uyetsvrt**g**pjr*et*t*vji**k*e*x**bt**qpf*gth***j*y*zl*xg*v*" +
                "ui**q*******s*p**v***p*k*w*tu**qeiq*m***dvp*g***ut**j**r***p*di*****s*d****c*w**y***vbnv*b**dveszb" +
                "gyh***ilzir*fe**tx**dla*o**sc**p***f*gxr**fg*cdipbcc***k***o*qi*g*kolg*otn*j*t******v**r*e**xubda*" +
                "g***hs*mfw***ws**k*bns**gsvh*hl*fo***o*e*ng**t*klx*dg*a*w*j*tww****n**z*****z**po****m*****q*kljxg" +
                "lo**p**u*jcs**o**f****t**z**oz***c*o****q*********rxb*xvy*hupl****r*hp*x*bhm***rzno*l**q*j*ms*h*vu" +
                "**k***r*o*p*b****j**ojpf*n****xw***w*b*rm**npq**u**dubwse*belkh**qwxja*x**s*dbpz**hbp*****m**hwdxz" +
                "**rtxpc*q***d*h******yne**vix****kurm**lf***y*xt*ug**dui*y*uqplhho*a*o***axi*guf**hl**re*n**f*vl**" +
                "*z*tv*guyn**iy**e**cb*****bku*ix*fu*f**t**g*ob*h****bniw*ju***x***y*x**d*r****i*m****h*iq*kxer*z*y" +
                "****nu*g****e**g***kwhwpv*ccrjv*n**mv*l*cnf*x**y**a*n*r*ddkp*b*f*pf*ib*b*q*vsstivdw*bd*y*j**tb**co" +
                "***poa**tv*mr******xm*mib****xei*f******reu*bh***v**e*diez**ska***nme*dom*mg****ot***zsjhiw*w****p" +
                "*******tl*j****w*j****vgh*hm***g*bki*lrzgdmk*gf**up**********p****ao*lu*rwst**x*qc*t*ql****h**hmpt" +
                "a***a***bm*sv**eudj*wd*k*fgr*a*****k*i**ue*a*o**y*fs*********mfg****b****caiob****j*x**x*vg*****f*" +
                "w**q***uqde*u*svj**x*m*****ak*b*ej****daza****ry*ntku*w**sp*v*x**as*wy*bwzm*bg*neb**t*z****f*ruqv*" +
                "zz*vgavp**yk*k*ztu**z*gjn**ggr**c*j*vo*s*t*ee*owid*tsex*j*crp*l***********dvh**sn*ac*uusy***e**p**" +
                "m*b*cc**a**s*yi***e*wp*scvoriq**o*tzl*try*oahbp***dj*q*j*osx*****of*r**rpm***nsm*f**f*j*kccu**h*jc" +
                "***********j*oq***rj**o**dv****y*s*qteyx*e**zc**i**e*****k*e***atv*d***m**uro*x**z*o*sr*v*a***p*av" +
                "i*nt**a*y*i*r*r*rz**i***jt**o**ml*h***km*kx*z***m*qfcc**c***x***h**irix*lj***f*y*y*v*kahbm*jktnljs" +
                "hbp*d*pe***v*hp*m**pg*vi***cm*s*ok*jw**tuk*j**ng*wr**m*****osgr****d**sw*f*m****ueak*zsrg**c*a**j*" +
                "y*g**dk**k*yk**duwo**lh**y*m****goi*******nl**ssm*izv****ig*********hd*uxp*x**lgrx*ubyanc*c**rjdo*" +
                "**ook****g***ebhju**mw**peqgzv*f*i**lp*g*w*u********rl*xe**j***qx**t*z*n*o*h**s******motuz*******q" +
                "xh*r*yc*v**qcxs*lbf**u**yc*pl*g*pv*r*e**o****c*v*w*p***cp***o**z*s*wtbga*ymwq*e**ocvda***s**b*p*fr" +
                "gq*v**htuouth*l*hz***onw*ed*u*l**b***zls*y**bg**e*lb*wkoc***m*r*****ab*o*o*es***x*i**w**h**fq***c*" +
                "zd*s*kariev*huw*ckp*q***fz**oll*r******ne****rgmw**w**wq**qr****r*op**s*choi******hh*a*x**ico*mbbh" +
                "*vbf*rim*mn*xv**sh********b***k*ur*onl*****r***k**k***g***w**b*x*kc**cg*a***q**zr*****n**i**u*gzo*" +
                "**g*qqs*ah**c*lt****n*o*s*i***y*r*f*u*lq**s**w**t**bdw*lhf*p******hj*d*dq*f*a*i*hog*s****s**ap*s*b" +
                "a*****qi*rrf**g****y*xxrl***z******ncr*at**rvpqih*i*x*juj**ho****h**c*l**kd**h*l*sex**j*j**h*r****" +
                "*op**axycqkd*e*h******mb***yoyl*q***q**itzlyu***ltpcs*v**utc**c*a*tb***jva***l******lh**saqmusv*wp" +
                "**dafyb*n*zfg**w*coqo*gvlhzd*t*svca***q**vsq*pr*jq*zeqfxi***mv**hdkzht*x**bhqj***aqzfl*bpax*******" +
                "zc*gmp***uty****b*smkfy**l*bg*tjcd*sula*****zus*j****ca*a**h***j****z***mfw*s*n*jk*h**q*zjwp*l*qej" +
                "l**a****sz**im***ub**vm*dzr**o*p**lf**tgwv**f*ot******m*vh*a*yp****d***lbq**s*ieb*t*h*c*e**d**urjz" +
                "w***bf*moz***fcn*dslgl*w*zr*dayvj**t*zd***y*ge***iifj**id*clxu*toxzx*aqqx***x*l*la**m******mb*n***" +
                "***exr*h*p*txgy***znqu*f*mdmw***xx***s**t***t*sqq**jyulayxk*xdx**n*rsd*vff*nk*qmavv*iay**qc**j**s*" +
                "*w*s*j*o*cc**z***slyf**o******q**b**x*ezu***n*n*frze*yy*al*****k**ge*o*z****b**k*oo*fk**s**pwa*r*v" +
                "**g*u**rhnx**p**m****sucva*s**xp****k*d*****p***r*c*u*w*n**g*d***ctw**du*xu*j*q**ih**t****vzk***jn" +
                "if***yr*k***py*gbk**w*u***b*t*u**t*d**iy******pckf**xqgasb*w***k****rdgzrx**kv*o***jl*vi**d**xi**k" +
                "****ri*xt****m*wmxiu*p*va*bte*ymlqssdcv****b**ebc**js**a***y*p****cvahr**k*ut**dv*b*u*ea*****a*v**" +
                "ry**t*l*****t**evtote*pn*d*i****d*c**zo***q*pk*f*ot*v*z*vj****p**lqjb*a********j**wk*n****bgs**m*h" +
                "****po*ih*rejh*dv**s***mbur******od**x*wx****iquk*o***z*iy*mvyn*fvz*v*j**s*u***va*ekpj*d*emw*w*za*" +
                "*y*h*flu*******xtmrvz*kz********f***o***sa*gq***abt*h*n*o*dd*ij*d***ig*oqff*e***fn*lxs*zt****nemx*" +
                "ex*gt**nh****tf*n***f*y**p*g****iao**o*j*zug*******p***gql*pt*bnrh**xnu*q*********p*l*a*d***qg**i*" +
                "gl*o*******cu*abpt*yk*ur*zyp**z**q*gveg*avv*b*lv****wo**eirum*y*r***w*g*y*****br*nj**u********g**n" +
                "nie**h*svf**c*yx**utnzr**tja*t****sur*ahj**kt*aryp*****m*ni*nn****l***fl*po*v*om****jdcqo***cy*";
        long start = System.currentTimeMillis();
        System.out.println(removeStars(s));
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("timeElapsed = " + timeElapsed);
    }
    
    public static String removeStars(String s) { // 2713ms
        final char[] chars = s.toCharArray();
        List<Integer> starIndexes = detectStarIndexes(chars);
        
        final int size = starIndexes.size();
        for (int i = 0; i < size; i++) {
            detectPreviousIndexes(starIndexes, i, 1);
        }

        return keepCharInIndexes(chars, starIndexes);
    }

    private static String keepCharInIndexes(char[] charArray, List<Integer> starIndexes) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (!starIndexes.contains(i)) {
                result.append(charArray[i]);
            }
        }
        return result.toString();
    }

    private static List<Integer> detectStarIndexes(char[] charArray) {
        List<Integer> starIndexes = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == STAR_SYMBOL) {
                starIndexes.add(i);
            }
        }
        return starIndexes;
    }

    private static void detectPreviousIndexes(List<Integer> starIndexes, int i, int j) {
        if (starIndexes.contains(starIndexes.get(i) - j)) {
            detectPreviousIndexes(starIndexes, i, ++j);
        } else {
            starIndexes.add(starIndexes.get(i) - j);
        }
    }

    public static String removeStarsFastest(String s) { // 2ms
        StringBuilder sb = new StringBuilder();
        for (final char c : s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

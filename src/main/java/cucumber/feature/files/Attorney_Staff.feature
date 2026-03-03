Feature: Attorney + Staff - Canadian unique datasets (@yopmail.com)

@Attorney
Scenario Outline: Add Attorney using Canadian dataset <Row>
  Given Attorney_Add with data:
    | Key                      | Value           |
    | Attorney.First Name       | <A_First>       |
    | Attorney.Middle Name      | <A_Middle>      |
    | Attorney.Last Name        | <A_Last>        |
    | Attorney.Name Suffix      | <A_Suffix>      |
    | Attorney.Phone            | <A_Phone>       |
    | Attorney.Office phone     | <A_OfficePhone> |
    | Attorney.Email            | <A_Email>       |
    | LawFirm.ID                | <LF_ID>         |
    | LawFirm.Name              | <LF_Name>       |
    | LawFirm.Phone             | <LF_Phone>      |
    | Staff.Staff First Name    | <S_First>       |
    | Staff.Staff Middle Name   | <S_Middle>      |
    | Staff.Staff Last Name     | <S_Last>        |
    | Staff.Staff Name Suffix   | <S_Suffix>      |
    | Staff.Staff Phone         | <S_Phone>       |
    | Staff.Staff Office phone  | <S_OfficePhone> |
    | Staff.Staff Email         | <S_Email>       |

  Examples:
    | Row | A_First             | A_Middle  | A_Last        | A_Suffix | A_Phone     | A_OfficePhone | A_Email                                      | LF_ID       | LF_Name                            | LF_Phone     | S_First            | S_Middle | S_Last        | S_Suffix | S_Phone     | S_OfficePhone | S_Email                                   |
    | 1   | Attorney Tamsin      | Elowyn    | MacEachern    | II       | 4165553101  | 4165554101    | attorney.tamsin.maceachern01@yopmail.com     | LF-CA-9101  | Fjord & Finch Trial Group          | 4165555101   | Staff Tegwen       | Sabine   | Hargreaves   | Jr       | 6475556101  | 6475557101    | staff.tegwen.hargreaves01@yopmail.com     |
    | 2   | Attorney Merritt     | Calder    | Theriault     | III      | 5145553102  | 5145554102    | attorney.merritt.theriault02@yopmail.com     | LF-CA-9102  | CopperKettle Docketworks           | 5145555102   | Staff Carys        | Laurel   | Coulombe     | II       | 4385556102  | 4385557102    | staff.carys.coulombe02@yopmail.com        |
    | 3   | Attorney Keir        | Moira     | Kavanagh      | Sr       | 6135553103  | 6135554103    | attorney.keir.kavanagh03@yopmail.com         | LF-CA-9103  | Hudson Strait Briefworks           | 6135555103   | Staff Linden       | Cecily   | MacIsaac     | III      | 3435556103  | 3435557103    | staff.linden.macisaac03@yopmail.com       |
    | 4   | Attorney Sian        | Isolde    | McKinnon      | IV       | 9055553104  | 9055554104    | attorney.sian.mckinnon04@yopmail.com         | LF-CA-9104  | Kootenay Claims Counsel            | 9055555104   | Staff Hollis       | Blaire   | Weatherby    | Sr       | 2895556104  | 2895557104    | staff.hollis.weatherby04@yopmail.com      |
    | 5   | Attorney Brigid      | Fergus    | ORourke       | Jr       | 6045553105  | 6045554105    | attorney.brigid.orourke05@yopmail.com        | LF-CA-9105  | Algonquin Pleadings Studio         | 6045555105   | Staff Juniper      | Nerida   | Tremlett     | IV       | 7785556105  | 7785557105    | staff.juniper.tremlett05@yopmail.com      |
    | 6   | Attorney Greer       | Alastair  | Beaudoin      | II       | 4035553106  | 4035554106    | attorney.greer.beaudoin06@yopmail.com        | LF-CA-9106  | Prairie Lantern Litigation         | 4035555106   | Staff Maren        | Odile    | Blackwood    | Jr       | 5875556106  | 5875557106    | staff.maren.blackwood06@yopmail.com       |
    | 7   | Attorney Ewan        | Rowan     | Sinclair      | III      | 7805553107  | 7805554107    | attorney.ewan.sinclair07@yopmail.com         | LF-CA-9107  | Atlantic Seaboard Trialcraft       | 7805555107   | Staff Teagan       | Imogen   | Beauregard   | II       | 8255556107  | 8255557107    | staff.teagan.beauregard07@yopmail.com     |
    | 8   | Attorney Pippa       | Arianne   | Lalonde       | Sr       | 3065553108  | 3065554108    | attorney.pippa.lalonde08@yopmail.com         | LF-CA-9108  | Snowcap Civil Practice             | 3065555108   | Staff Willa        | Corinne  | McQuade      | III      | 6395556108  | 6395557108    | staff.willa.mcquade08@yopmail.com         |
    | 9   | Attorney Lorne       | Quentin   | Chabot        | IV       | 2045553109  | 2045554109    | attorney.lorne.chabot09@yopmail.com          | LF-CA-9109  | Northern Birch Legal Mechanics     | 2045555109   | Staff Eamon        | Sable    | Stoneman     | Sr       | 4315556109  | 4315557109    | staff.eamon.stoneman09@yopmail.com        |
    | 10  | Attorney Niall       | Siobhan   | MacLeod       | Jr       | 7055553110  | 7055554110    | attorney.niall.macleod10@yopmail.com         | LF-CA-9110  | Maple Crown Casebuilders           | 7055555110   | Staff Fiadh        | Tamsin   | Kirwan       | IV       | 2495556110  | 2495557110    | staff.fiadh.kirwan10@yopmail.com          |
    | 11  | Attorney Alasdair    | Mirella   | Pembry        | II       | 8195553111  | 8195554111    | attorney.alasdair.pembry11@yopmail.com       | LF-CA-9111  | Rainshadow Brief House             | 8195555111   | Staff Evangeline   | Maevis   | Delaney      | Jr       | 8735556111  | 8735557111    | staff.evangeline.delaney11@yopmail.com    |
    | 12  | Attorney Eilish      | Bronwyn   | Fairweather   | III      | 4185553112  | 4185554112    | attorney.eilish.fairweather12@yopmail.com    | LF-CA-9112  | Granite Coast Counsel              | 4185555112   | Staff Bryn         | Jocelyn  | Vandermeer   | II       | 5815556112  | 5815557112    | staff.bryn.vandermeer12@yopmail.com       |
    | 13  | Attorney Bryony      | Lachlan   | Ashdown       | Sr       | 9025553113  | 9025554113    | attorney.bryony.ashdown13@yopmail.com        | LF-CA-9113  | Red River Docket Foundry           | 9025555113   | Staff Keltie       | Renae    | Goudreau     | III      | 7825556113  | 7825557113    | staff.keltie.goudreau13@yopmail.com       |
    | 14  | Attorney Cormac      | Elspeth   | Tupper        | IV       | 5065553114  | 5065554114    | attorney.cormac.tupper14@yopmail.com         | LF-CA-9114  | Highridge Pleading Bureau          | 5065555114   | Staff Harlow       | Yvette   | MacNab       | Sr       | 5065556114  | 5065557114    | staff.harlow.macnab14@yopmail.com         |
    | 15  | Attorney Afton       | Iona      | Winslow       | Jr       | 7095553115  | 7095554115    | attorney.afton.winslow15@yopmail.com         | LF-CA-9115  | Beacon Harbour Litigation          | 7095555115   | Staff Callie       | Blythe   | Braithwaite  | IV       | 7095556115  | 7095557115    | staff.callie.braithwaite15@yopmail.com    |
    | 16  | Attorney Shona       | Mairi     | Lockhart      | II       | 5195553116  | 5195554116    | attorney.shona.lockhart16@yopmail.com        | LF-CA-9116  | Timberline Trial Partners          | 5195555116   | Staff Lennie       | Giselle  | Courville    | Jr       | 2265556116  | 2265557116    | staff.lennie.courville16@yopmail.com      |
    | 17  | Attorney Roisin      | Deirdre   | Dunlop        | III      | 2265553117  | 2265554117    | attorney.roisin.dunlop17@yopmail.com         | LF-CA-9117  | BlueRock Claims Atelier            | 2265555117   | Staff Rowenna      | Sandrine| Henshaw      | II       | 5195556117  | 5195557117    | staff.rowenna.henshaw17@yopmail.com       |
    | 18  | Attorney Gideon      | Peregrine | Carstairs     | Sr       | 6475553118  | 6475554118    | attorney.gideon.carstairs18@yopmail.com      | LF-CA-9118  | SilverLoon Legal Studio            | 6475555118   | Staff Sorcha       | Nadine  | McPherson    | III      | 4375556118  | 4375557118    | staff.sorcha.mcpherson18@yopmail.com      |
    | 19  | Attorney Saskia      | Delphine  | Hallowell     | IV       | 4505553119  | 4505554119    | attorney.saskia.hallowell19@yopmail.com      | LF-CA-9119  | SummitSpruce Docketwrights         | 4505555119   | Staff Maevis       | Colette | Fallowfield  | Sr       | 5795556119  | 5795557119    | staff.maevis.fallowfield19@yopmail.com    |
    | 20  | Attorney Mairi       | Linnea    | Pomerleau     | Jr       | 2365553120  | 2365554120    | attorney.mairi.pomerleau20@yopmail.com       | LF-CA-9120  | Aurora Gate Trial Rooms            | 2365555120   | Staff Catriona     | Elodie  | Kingsnorth   | IV       | 2505556120  | 2505557120    | staff.catriona.kingsnorth20@yopmail.com   |
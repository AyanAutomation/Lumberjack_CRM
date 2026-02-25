Feature: Case Module (Add Case + Revised Contract + Message Template)

  @case_plus_plaintiff
  Scenario Outline: Add case using combined dataset
    Given Add_case_cucumber with data:
      | Key                              | Value                |
      | Case.Case #                      | <CaseNum>            |
      | Case.Case Type                   | <CaseType>           |
      | Case.State                       | <CaseState>          |
      | Case.Date of Incident            | <IncidentDate>       |
      | Case.Lead Source                 | <LeadSource>         |
      | Case.Requested Amount            | <ReqAmount>          |
      | Case.Court Index Number          | <CourtIndex>         |
      | Case.Summary                     | <Summary>            |
      | Case.Buyout Funder Name          | <BuyoutFunder>       |
      | Case.Buyout Amount               | <Buyout>             |
      | Case.Approved Amount             | <Approved>           |
      | Case.Document prep fee           | <PrepFee>            |
      | Case.Fund transfer fee           | <TransFee>           |
      | Case.Rate of Return              | <ROR>                |
      | Case.Underwriting Notes          | <Notes>              |
      | Case.Underwriting Tag            | <Tag>                |

      # dynamic system dates (your Java overwrites these anyway)
      | Case.Payment Date                | AUTO                 |
      | Case.Agreement Date              | AUTO                 |
      | Case.Interest Start Date         | AUTO                 |
      | Case.Buyout Expiry Date          | AUTO                 |

      # REQUIRED for Payment_Calculator / Payment_Logger (prevents nulls)
      | Case.Payment Mode                | Credit Card          |
      | Case.Payment Type                | Payment by Plaintiff |
      | Case.Payer Name                  | Plaintiff N/A        |
      | Case.Notes / Remarks             | N/A                  |

      | Plaintiff.First Name             | <PltfFirst>          |
      | Plaintiff.Last Name              | <PltfLast>           |
      | Attorney.First Name              | <AttrFirst>          |
      | Attorney.Email                   | <AttrEmail>          |
      | LawFirm.Name                     | <LFName>             |

      # safe defaults (if your attorney add flow uses staff later)
      | Staff.Staff First Name           | Staff Nivaren        |
      | Staff.Staff Email                | staff.nivaren.thornwick25@mailto.plus |

      # optional email defaults (only if you reuse email steps later)
      | Email.Template                   | None                 |
      | Email.Subject                    | Document Request     |
      | Email.To                         | intake@example.com   |
      | Email.Cc                         | cc@example.com       |
      | Email.Bcc                        | bcc@example.com      |
      | Email.Message                    | Hello,\n\nPlease upload required documents.\n\nThank you. |

    Examples:
      | CaseNum | CaseType            | CaseState      | IncidentDate | LeadSource  | ReqAmount | CourtIndex | Summary           | BuyoutFunder                         | Buyout | Approved | PrepFee | TransFee | ROR | Notes            | Tag            | PltfFirst | PltfLast   | AttrFirst         | AttrEmail                                    | LFName                          |
      | 521     | Premises Liability  | California     | 03/09/2024   | Advertising | 73500     | 19CV-4921  | Slip on tile...   | Juniper Vale Litigation Capital       | 19600  | 31000    | 325     | 120      | 44  | Verify footage   | Surveillance   | Holden    | Glassford  | Attorney Maëlys   | attorney.maelys.beausoleil01@yopmail.com     | VerdictForge Litigation Atelier |
      | 522     | Discrimination      | Texas          | 11/14/2023   | Referral    | 59000     | 07CV-7113  | Demotion alleged  | Crownstone Settlement Finance         | 14800  | 24500    | 290     | 105      | 41  | Validate charge  | Comparator     | Marston   | Cavendish  | Attorney Éloïse   | attorney.eloise.montpetit02@mailto.plus      | NorthStar Docketworks           |
      | 523     | Breach of contract  | New York       | 07/02/2023   | Broker      | 86000     | 31CV-9405  | Vendor dispute    | Obsidian Harbor Funding Partners      | 22400  | 36000    | 365     | 135      | 48  | Confirm contract | Collectability | Corinne   | Haverly    | Attorney Callum   | attorney.callum.kincaidrowe03@mailto.plus    | Cascade Claimcraft Legal Studio |
      | 524     | Dog Bite            | Florida        | 01/28/2024   | Medical     | 21000     | 11CV-6732  | Infection/scar    | Seabright Plaintiff Capital           | 5100   | 9200     | 215     | 75       | 33  | Confirm coverage | Coverage Verif | Bennett   | Ashbourne  | Attorney Siobhan  | attorney.siobhan.belanger04@mailto.plus      | Keystone Dispute Lab            |
      | 525     | Employment Disputes | Washington     | 09/18/2024   | Organic     | 45500     | 05CV-3118  | Retaliation       | Verdant Peak Litigation Finance       | 11200  | 19000    | 275     | 95       | 39  | Verify dates     | Arbitration    | Harper    | Morringate | Attorney Théodore | attorney.theodore.ducharme05@mailto.plus     | Peachtree Litigation Works      |
      | 526     | Workers Comp        | Ohio           | 10/03/2023   | Other       | 29500     | 18WC-5804  | Shoulder strain   | Ironleaf Recovery Capital             | 7200   | 12000    | 245     | 85       | 36  | IME dispute      | IME/Carrier    | Declan    | Kinsleigh  | Attorney Mireille | attorney.mireille.laframboise06@mailto.plus  | HarborLedger Trial Office       |
      | 527     | Negligence          | Colorado       | 04/12/2024   | Broker      | 51500     | 02CV-8219  | Tripped on ramp   | Stonegate Plaintiff Funding           | 12900  | 21000    | 285     | 100      | 40  | Confirm permits  | Permit/Plan    | Amina     | Rahbourne  | Attorney Lachlan  | attorney.lachlan.macquarrie07@mailto.plus    | BayState Casebuilders           |
      | 528     | Property Damage     | Georgia        | 02/02/2024   | Organic     | 34000     | 09CV-1668  | Water intrusion   | Harborglint Legal Finance             | 8200   | 14500    | 255     | 90       | 37  | Repair timeline  | Mitigation     | Rosalind  | Denwick    | Attorney Geneviève| attorney.genevieve.thibodeau08@mailto.plus   | MillCity Docket Foundry         |
      | 529     | Wrongful Arrest     | Arizona        | 05/26/2024   | Advertising | 48000     | 13CV-2744  | Mistaken identity | Kestrel Point Litigation Capital      | 10800  | 19500    | 270     | 95       | 38  | Confirm dismiss  | Disposition    | Eamon     | Keystone   | Attorney Rhys     | attorney.rhys.deslauriers09@mailto.plus      | Gateway Pleading House          |
      | 530     | Unpaid Wages        | Pennsylvania   | 12/05/2023   | Other       | 24000     | 17CV-1902  | Overtime unpaid   | Blue Lantern Funding Co.              | 5600   | 9800     | 225     | 75       | 34  | Payroll integrity| Reconciliation | Maeve     | Theron     | Attorney Ainsley  | attorney.ainsley.houde10@mailto.plus         | PrairieMotion Claims Studio     |
      | 531     | Products Liability  | Washington DC  | 08/17/2023   | Broker      | 66500     | 01CV-5331  | Battery fire      | Redwood Axis Litigation Finance       | 17400  | 29500    | 310     | 115      | 46  | Preservation     | Chain-of-Cust  | Talia     | Kawson     | Attorney Étienne  | attorney.etienne.cormier11@mailto.plus       | FrontRange Trial Mechanics      |
      | 532     | Assault             | Nevada         | 06/21/2024   | Organic     | 42000     | 08CV-1114  | Dental trauma     | Silvercrest Legal Capital             | 11100  | 18200    | 255     | 95       | 40  | Venue logs       | Coverage Disc  | Julian    | Laford     | Attorney Bronwen  | attorney.bronwen.chartrand12@mailto.plus     | Capitol Briefworks              |
      | 533     | Sexual Harassment   | Oregon         | 02/08/2024   | Referral    | 57500     | 06CV-3879  | Internal logs     | Firwood Litigation Funding            | 13800  | 23000    | 275     | 100      | 41  | HR outcome       | Retaliation    | Mirella   | Beaulieux  | Attorney Dashiell | attorney.dashiell.vezina13@mailto.plus       | SunCoast Liability Atelier      |
      | 534     | Civil Rights        | Virginia       | 09/29/2024   | Other       | 81500     | 10CV-6201  | Unlawful search   | Cobalt Meridian Legal Finance         | 20800  | 34000    | 335     | 125      | 43  | Bodycam Cad logs | Video Verif    | Finley    | Carmick    | Attorney Rosalie  | attorney.rosalie.beauchamp14@mailto.plus     | InlandBrief Trial Rooms         |
      | 535     | Police Brutality    | Illinois       | 04/03/2024   | Organic     | 91000     | 14CV-1774  | Use of force      | Summit Harbor Litigation Capital      | 24200  | 39000    | 355     | 130      | 45  | Criminal disp    | Causation Rev  | Darian    | Gilmore    | Attorney Soren    | attorney.soren.paquette15@mailto.plus        | Silicon Valley Caseworks Bureau |
      | 536     | Legal Malpractice   | Massachusetts  | 01/19/2023   | Referral    | 77000     | 04CV-4118  | Missed deadline   | Harborline Counsel Finance            | 19600  | 32000    | 330     | 120      | 44  | Docket history   | Carrier Resp   | Edith     | Charton    | Attorney Nyla     | attorney.nadine.gagnonlevesque16@mailto.plus | DuPage Trialcraft Office        |
      | 537     | Boat Accident       | Hawaii         | 05/11/2024   | Broker      | 64000     | 01CV-2907  | Marina collision  | Frontline Oceanic Capital             | 16400  | 26000    | 295     | 105      | 40  | Marine patrol    | Report Pending | Taliah    | Qitson     | Attorney Kael     | attorney.kieran.marchand17@mailto.plus       | RiverBend Pleading Studio       |
      | 538     | Airplane Accident   | Utah           | 03/24/2023   | Referral    | 124000    | 03CV-8640  | Hard landing      | Pioneer Aviation Claim Finance        | 36800  | 59000    | 375     | 140      | 47  | Maintenance log  | Investigation  | Reagan    | Vermeer    | Attorney Elara    | attorney.anais.bourque18@mailto.plus         | SummitCourt Litigation Desk     |
      | 539     | Attorney Funding    | New Jersey     | 08/30/2023   | Referral    | 84500     | 02CV-3409  | Expert retainers  | Granite Arc Legal Capital             | 23200  | 36500    | 315     | 120      | 43  | Litigation budg  | Milestone Disb | Roisin    | Quenby     | Attorney Mira     | attorney.declan.tremblayfox19@mailto.plus    | Sonoran Docketwright Office     |
      | 540     | Civil Rights        | Connecticut    | 12/27/2024   | Other       | 50500     | 00CV-1990  | Intake review     | Atlas Ridge Litigation Funding        | 12400  | 20500    | 260     | 95       | 39  | Venue confirm    | Venue Confirm  | Marlis    | Gravelton  | Attorney Vivienne | attorney.vivienne.landry20@mailto.plus       | SangreBrief Civil Practice Atelier |


  @revise_contract
  Scenario Outline: Buyout Add + Fees Changed in Revised Contract (reuse same dataset)
    Given Buyout_Add_and_Fees_changed_in_Revised_Contract with data:
      | Key                              | Value                |
      | Case.Case #                      | <CaseNum>            |
      | Case.Case Type                   | <CaseType>           |
      | Case.State                       | <CaseState>          |
      | Case.Date of Incident            | <IncidentDate>       |
      | Case.Lead Source                 | <LeadSource>         |
      | Case.Requested Amount            | <ReqAmount>          |
      | Case.Court Index Number          | <CourtIndex>         |
      | Case.Summary                     | <Summary>            |
      | Case.Buyout Funder Name          | <BuyoutFunder>       |
      | Case.Buyout Amount               | <Buyout>             |
      | Case.Approved Amount             | <Approved>           |
      | Case.Document prep fee           | <PrepFee>            |
      | Case.Fund transfer fee           | <TransFee>           |
      | Case.Rate of Return              | <ROR>                |
      | Case.Underwriting Notes          | <Notes>              |
      | Case.Underwriting Tag            | <Tag>                |

      # dynamic system dates (your Java overwrites these anyway)
      | Case.Payment Date                | AUTO                 |
      | Case.Agreement Date              | AUTO                 |
      | Case.Interest Start Date         | AUTO                 |
      | Case.Buyout Expiry Date          | AUTO                 |

      # REQUIRED for Payment_Calculator / Payment_Logger (prevents nulls)
      | Case.Payment Mode                | Credit Card          |
      | Case.Payment Type                | Payment by Plaintiff |
      | Case.Payer Name                  | Plaintiff N/A        |
      | Case.Notes / Remarks             | N/A                  |

      | Plaintiff.First Name             | <PltfFirst>          |
      | Plaintiff.Last Name              | <PltfLast>           |
      | Attorney.First Name              | <AttrFirst>          |
      | Attorney.Email                   | <AttrEmail>          |
      | LawFirm.Name                     | <LFName>             |

      | Staff.Staff First Name           | Staff Nivaren        |
      | Staff.Staff Email                | staff.nivaren.thornwick25@mailto.plus |

      | Email.Template                   | None                 |
      | Email.Subject                    | Document Request     |
      | Email.To                         | intake@example.com   |
      | Email.Cc                         | cc@example.com       |
      | Email.Bcc                        | bcc@example.com      |
      | Email.Message                    | Hello,\n\nPlease upload required documents.\n\nThank you. |

    Examples:
      | CaseNum | CaseType            | CaseState      | IncidentDate | LeadSource  | ReqAmount | CourtIndex | Summary           | BuyoutFunder                         | Buyout | Approved | PrepFee | TransFee | ROR | Notes            | Tag            | PltfFirst | PltfLast   | AttrFirst         | AttrEmail                                    | LFName                          |
      | 521     | Premises Liability  | California     | 03/09/2024   | Advertising | 73500     | 19CV-4921  | Slip on tile...   | Juniper Vale Litigation Capital       | 19600  | 31000    | 325     | 120      | 44  | Verify footage   | Surveillance   | Holden    | Glassford  | Attorney Maëlys   | attorney.maelys.beausoleil01@yopmail.com     | VerdictForge Litigation Atelier |
      | 522     | Discrimination      | Texas          | 11/14/2023   | Referral    | 59000     | 07CV-7113  | Demotion alleged  | Crownstone Settlement Finance         | 14800  | 24500    | 290     | 105      | 41  | Validate charge  | Comparator     | Marston   | Cavendish  | Attorney Éloïse   | attorney.eloise.montpetit02@mailto.plus      | NorthStar Docketworks           |
      | 523     | Breach of contract  | New York       | 07/02/2023   | Broker      | 86000     | 31CV-9405  | Vendor dispute    | Obsidian Harbor Funding Partners      | 22400  | 36000    | 365     | 135      | 48  | Confirm contract | Collectability | Corinne   | Haverly    | Attorney Callum   | attorney.callum.kincaidrowe03@mailto.plus    | Cascade Claimcraft Legal Studio |
      | 524     | Dog Bite            | Florida        | 01/28/2024   | Medical     | 21000     | 11CV-6732  | Infection/scar    | Seabright Plaintiff Capital           | 5100   | 9200     | 215     | 75       | 33  | Confirm coverage | Coverage Verif | Bennett   | Ashbourne  | Attorney Siobhan  | attorney.siobhan.belanger04@mailto.plus      | Keystone Dispute Lab            |
      | 525     | Employment Disputes | Washington     | 09/18/2024   | Organic     | 45500     | 05CV-3118  | Retaliation       | Verdant Peak Litigation Finance       | 11200  | 19000    | 275     | 95       | 39  | Verify dates     | Arbitration    | Harper    | Morringate | Attorney Théodore | attorney.theodore.ducharme05@mailto.plus     | Peachtree Litigation Works      |
      | 526     | Workers Comp        | Ohio           | 10/03/2023   | Other       | 29500     | 18WC-5804  | Shoulder strain   | Ironleaf Recovery Capital             | 7200   | 12000    | 245     | 85       | 36  | IME dispute      | IME/Carrier    | Declan    | Kinsleigh  | Attorney Mireille | attorney.mireille.laframboise06@mailto.plus  | HarborLedger Trial Office       |
      | 527     | Negligence          | Colorado       | 04/12/2024   | Broker      | 51500     | 02CV-8219  | Tripped on ramp   | Stonegate Plaintiff Funding           | 12900  | 21000    | 285     | 100      | 40  | Confirm permits  | Permit/Plan    | Amina     | Rahbourne  | Attorney Lachlan  | attorney.lachlan.macquarrie07@mailto.plus    | BayState Casebuilders           |
      | 528     | Property Damage     | Georgia        | 02/02/2024   | Organic     | 34000     | 09CV-1668  | Water intrusion   | Harborglint Legal Finance             | 8200   | 14500    | 255     | 90       | 37  | Repair timeline  | Mitigation     | Rosalind  | Denwick    | Attorney Geneviève| attorney.genevieve.thibodeau08@mailto.plus   | MillCity Docket Foundry         |
      | 529     | Wrongful Arrest     | Arizona        | 05/26/2024   | Advertising | 48000     | 13CV-2744  | Mistaken identity | Kestrel Point Litigation Capital      | 10800  | 19500    | 270     | 95       | 38  | Confirm dismiss  | Disposition    | Eamon     | Keystone   | Attorney Rhys     | attorney.rhys.deslauriers09@mailto.plus      | Gateway Pleading House          |
      | 530     | Unpaid Wages        | Pennsylvania   | 12/05/2023   | Other       | 24000     | 17CV-1902  | Overtime unpaid   | Blue Lantern Funding Co.              | 5600   | 9800     | 225     | 75       | 34  | Payroll integrity| Reconciliation | Maeve     | Theron     | Attorney Ainsley  | attorney.ainsley.houde10@mailto.plus         | PrairieMotion Claims Studio     |
      | 531     | Products Liability  | Washington DC  | 08/17/2023   | Broker      | 66500     | 01CV-5331  | Battery fire      | Redwood Axis Litigation Finance       | 17400  | 29500    | 310     | 115      | 46  | Preservation     | Chain-of-Cust  | Talia     | Kawson     | Attorney Étienne  | attorney.etienne.cormier11@mailto.plus       | FrontRange Trial Mechanics      |
      | 532     | Assault             | Nevada         | 06/21/2024   | Organic     | 42000     | 08CV-1114  | Dental trauma     | Silvercrest Legal Capital             | 11100  | 18200    | 255     | 95       | 40  | Venue logs       | Coverage Disc  | Julian    | Laford     | Attorney Bronwen  | attorney.bronwen.chartrand12@mailto.plus     | Capitol Briefworks              |
      | 533     | Sexual Harassment   | Oregon         | 02/08/2024   | Referral    | 57500     | 06CV-3879  | Internal logs     | Firwood Litigation Funding            | 13800  | 23000    | 275     | 100      | 41  | HR outcome       | Retaliation    | Mirella   | Beaulieux  | Attorney Dashiell | attorney.dashiell.vezina13@mailto.plus       | SunCoast Liability Atelier      |
      | 534     | Civil Rights        | Virginia       | 09/29/2024   | Other       | 81500     | 10CV-6201  | Unlawful search   | Cobalt Meridian Legal Finance         | 20800  | 34000    | 335     | 125      | 43  | Bodycam Cad logs | Video Verif    | Finley    | Carmick    | Attorney Rosalie  | attorney.rosalie.beauchamp14@mailto.plus     | InlandBrief Trial Rooms         |
      | 535     | Police Brutality    | Illinois       | 04/03/2024   | Organic     | 91000     | 14CV-1774  | Use of force      | Summit Harbor Litigation Capital      | 24200  | 39000    | 355     | 130      | 45  | Criminal disp    | Causation Rev  | Darian    | Gilmore    | Attorney Soren    | attorney.soren.paquette15@mailto.plus        | Silicon Valley Caseworks Bureau |
      | 536     | Legal Malpractice   | Massachusetts  | 01/19/2023   | Referral    | 77000     | 04CV-4118  | Missed deadline   | Harborline Counsel Finance            | 19600  | 32000    | 330     | 120      | 44  | Docket history   | Carrier Resp   | Edith     | Charton    | Attorney Nyla     | attorney.nadine.gagnonlevesque16@mailto.plus | DuPage Trialcraft Office        |
      | 537     | Boat Accident       | Hawaii         | 05/11/2024   | Broker      | 64000     | 01CV-2907  | Marina collision  | Frontline Oceanic Capital             | 16400  | 26000    | 295     | 105      | 40  | Marine patrol    | Report Pending | Taliah    | Qitson     | Attorney Kael     | attorney.kieran.marchand17@mailto.plus       | RiverBend Pleading Studio       |
      | 538     | Airplane Accident   | Utah           | 03/24/2023   | Referral    | 124000    | 03CV-8640  | Hard landing      | Pioneer Aviation Claim Finance        | 36800  | 59000    | 375     | 140      | 47  | Maintenance log  | Investigation  | Reagan    | Vermeer    | Attorney Elara    | attorney.anais.bourque18@mailto.plus         | SummitCourt Litigation Desk     |
      | 539     | Attorney Funding    | New Jersey     | 08/30/2023   | Referral    | 84500     | 02CV-3409  | Expert retainers  | Granite Arc Legal Capital             | 23200  | 36500    | 315     | 120      | 43  | Litigation budg  | Milestone Disb | Roisin    | Quenby     | Attorney Mira     | attorney.declan.tremblayfox19@mailto.plus    | Sonoran Docketwright Office     |
      | 540     | Civil Rights        | Connecticut    | 12/27/2024   | Other       | 50500     | 00CV-1990  | Intake review     | Atlas Ridge Litigation Funding        | 12400  | 20500    | 260     | 95       | 39  | Venue confirm    | Venue Confirm  | Marlis    | Gravelton  | Attorney Vivienne | attorney.vivienne.landry20@mailto.plus       | SangreBrief Civil Practice Atelier |


  @message_template
  Scenario Outline: Create SMS message template (10 sets)
    Given Message_Template_Creator with data:
      | Key                   | Value   |
      | Case.SMS Message Title | <Title> |
      | Case.SMS Message Body  | <Body>  |

    Examples:
      | Title                            | Body                                                                 |
      | Doc Request - Missing Files      | Hello,\n\nPlease upload the pending documents.\n\nThank you.         |
      | Reminder - Action Needed         | Hi,\n\nThis is a reminder to complete the required steps.\n\nRegards.|
      | Case Update - Review In Progress | Hello,\n\nYour case is currently under review.\n\nWe will update you soon. |
      | Payment Update - Received        | Hi,\n\nWe have received your payment successfully.\n\nThank you.     |
      | Payment Reminder - Due Today     | Hello,\n\nYour payment is due today.\n\nPlease complete it to avoid delay. |
      | Agreement Ready - Please Sign    | Hi,\n\nYour agreement is ready.\n\nPlease review and sign at your earliest convenience. |
      | Follow-up - Additional Info      | Hello,\n\nWe need a few additional details to proceed.\n\nPlease reply when available. |
      | Document Reminder - Last Call    | Hi,\n\nFinal reminder to upload documents.\n\nThis is required to move forward. |
      | Status Update - Approved         | Hello,\n\nGood news—your case has been approved.\n\nThank you.        |
      | Status Update - Pending Docs     | Hi,\n\nYour case is pending documents.\n\nPlease upload them to continue. |
      
      
        @notes_add
  Scenario Outline: Add note in Notes tab for the target case
    Given Notes_Add with data:
      | Key            | Value      |
      | Case.Note Text | <NoteText> |

    Examples:
      | NoteText                                                     |
      | Follow-up: requested plaintiff to upload missing documents.   |
      | Verified attorney email; awaiting confirmation from law firm. |
      | Risk review: flagged for underwriting due to late filing.     |
      | Payment check: confirm fund transfer fee posted correctly.    |
      | Case update: reviewed incident date and court index details.  |
      
      
      
        @lien_accessor
  Scenario Outline: Open lien list page using direct URL
    Given Particular_Lien_Accessor with data:
      | Key      | Value     |
      | Lien.Url | <LienUrl> |

    Examples:
      | LienUrl                               |
      | https://dev.wechopfees.com/liens      |
      | https://dev.wechopfees.com/liens?tab=all |
      | https://dev.wechopfees.com/liens?sort=latest |
      
      
      
   @multi_app_generator
  Scenario Outline: Generate multiple application flow using dataset (no nulls)
    Given Multiple_Application_Generator with data:
      | Key                          | Value                |
      | Case.Case #                  | <CaseNum>            |
      | Case.Case Type               | <CaseType>           |
      | Case.State                   | <CaseState>          |
      | Case.Date of Incident        | <IncidentDate>       |
      | Case.Lead Source             | <LeadSource>         |
      | Case.Requested Amount        | <ReqAmount>          |
      | Case.Court Index Number      | <CourtIndex>         |
      | Case.Summary                 | <Summary>            |

      | Case.Buyout Funder Name      | <BuyoutFunder>       |
      | Case.Buyout Amount           | <Buyout>             |
      | Case.Approved Amount         | <Approved>           |
      | Case.Document prep fee       | <PrepFee>            |
      | Case.Fund transfer fee       | <TransFee>           |
      | Case.Rate of Return          | <ROR>                |

      | Case.Application Status      | <AppStatus>          |
      | Case.Risk Level              | <RiskLevel>          |
      | Case.Recommended Max Funding | <MaxFunding>         |
      | Case.Underwriting Notes      | <Notes>              |
      | Case.Underwriting Tag        | <Tag>                |

      | Case.Payment Date            | AUTO                 |
      | Case.Agreement Date          | AUTO                 |
      | Case.Interest Start Date     | AUTO                 |
      | Case.Buyout Expiry Date      | AUTO                 |

      | Case.Payment Mode            | Credit Card          |
      | Case.Payment Type            | Payment by Plaintiff |
      | Case.Payer Name              | Plaintiff N/A        |
      | Case.Notes / Remarks         | N/A                  |

      | Case.SMS Message Title       | N/A                  |
      | Case.SMS Message Body        | N/A                  |

      | Plaintiff.First Name         | <PltfFirst>          |
      | Plaintiff.Last Name          | <PltfLast>           |

      | Attorney.First Name          | <AttrFirst>          |
      | Attorney.Email               | <AttrEmail>          |

      | LawFirm.Name                 | <LFName>             |

      | Staff.Staff First Name       | Staff Nivaren        |
      | Staff.Staff Email            | staff.nivaren.thornwick25@mailto.plus |

      | Email.Template               | None                 |
      | Email.Subject                | Document Request     |
      | Email.To                     | intake@example.com   |
      | Email.Cc                     | cc@example.com       |
      | Email.Bcc                    | bcc@example.com      |
      | Email.Message                | Hello,\n\nPlease upload required documents.\n\nThank you. |

    Examples:
      | CaseNum | CaseType            | CaseState      | IncidentDate | LeadSource   | ReqAmount | CourtIndex | Summary            | BuyoutFunder                    | Buyout | Approved | PrepFee | TransFee | ROR | AppStatus     | RiskLevel      | MaxFunding | Notes               | Tag             | PltfFirst | PltfLast   | AttrFirst         | AttrEmail                                   | LFName                          |
      | 621     | Premises Liability  | California     | 03/09/2024   | Advertising  | 73500     | 19CV-4921  | Slip on tile...    | Juniper Vale Litigation Capital  | 19600  | 31000    | 325     | 120      | 44  | In Review     | Moderate       | 31000      | Verify footage      | Surveillance    | Holden    | Glassford  | Attorney Maëlys   | attorney.maelys.beausoleil01@yopmail.com    | VerdictForge Litigation Atelier |
      | 622     | Discrimination      | Texas          | 11/14/2023   | Referral     | 59000     | 07CV-7113  | Demotion alleged   | Crownstone Settlement Finance    | 14800  | 24500    | 290     | 105      | 41  | Pending Docs  | Moderate       | 24500      | Validate charge     | Comparator      | Marston   | Cavendish  | Attorney Éloïse   | attorney.eloise.montpetit02@mailto.plus     | NorthStar Docketworks           |
      | 623     | Breach of contract  | New York       | 07/02/2023   | Broker       | 86000     | 31CV-9405  | Vendor dispute     | Obsidian Harbor Funding Partners | 22400  | 36000    | 365     | 135      | 48  | In Review     | Moderate-High  | 36000      | Confirm contract    | Collectability  | Corinne   | Haverly    | Attorney Callum   | attorney.callum.kincaidrowe03@mailto.plus   | Cascade Claimcraft Legal Studio |
      | 624     | Dog Bite            | Florida        | 01/28/2024   | Medical      | 21000     | 11CV-6732  | Infection/scar     | Seabright Plaintiff Capital      | 5100   | 9200     | 215     | 75       | 33  | Approved      | Low-Moderate   | 9200       | Confirm coverage    | Coverage Verif  | Bennett   | Ashbourne  | Attorney Siobhan  | attorney.siobhan.belanger04@mailto.plus     | Keystone Dispute Lab            |
      | 625     | Employment Disputes | Washington     | 09/18/2024   | Organic      | 45500     | 05CV-3118  | Retaliation        | Verdant Peak Litigation Finance  | 11200  | 19000    | 275     | 95       | 39  | In Review     | Moderate       | 19000      | Verify dates        | Arbitration     | Harper    | Morringate | Attorney Théodore | attorney.theodore.ducharme05@mailto.plus    | Peachtree Litigation Works      |
      | 626     | Workers Comp        | Ohio           | 10/03/2023   | Other        | 29500     | 18WC-5804  | Shoulder strain    | Ironleaf Recovery Capital        | 7200   | 12000    | 245     | 85       | 36  | Pending Docs  | Moderate       | 12000      | IME dispute         | IME/Carrier     | Declan    | Kinsleigh  | Attorney Mireille | attorney.mireille.laframboise06@mailto.plus | HarborLedger Trial Office       |
      | 627     | Negligence          | Colorado       | 04/12/2024   | Broker       | 51500     | 02CV-8219  | Tripped on ramp    | Stonegate Plaintiff Funding      | 12900  | 21000    | 285     | 100      | 40  | Approved      | Moderate       | 21000      | Confirm permits     | Permit/Plan     | Amina     | Rahbourne  | Attorney Lachlan  | attorney.lachlan.macquarrie07@mailto.plus   | BayState Casebuilders           |
      | 628     | Property Damage     | Georgia        | 02/02/2024   | Organic      | 34000     | 09CV-1668  | Water intrusion    | Harborglint Legal Finance        | 8200   | 14500    | 255     | 90       | 37  | In Review     | Moderate       | 14500      | Repair timeline     | Mitigation      | Rosalind  | Denwick    | Attorney Geneviève| attorney.genevieve.thibodeau08@mailto.plus  | MillCity Docket Foundry         |
      | 629     | Civil Rights        | Washington DC  | 08/17/2023   | Broker       | 66500     | 01CV-5331  | Battery fire       | Redwood Axis Litigation Finance  | 17400  | 29500    | 310     | 115      | 46  | In Review     | Moderate-High  | 29500      | Preservation        | Chain-of-Cust   | Talia     | Kawson     | Attorney Étienne  | attorney.etienne.cormier11@mailto.plus      | FrontRange Trial Mechanics      |
      | 630     | Unpaid Wages        | Pennsylvania   | 12/05/2023   | Other        | 24000     | 17CV-1902  | Overtime unpaid    | Blue Lantern Funding Co.         | 5600   | 9800     | 225     | 75       | 34  | Pending Docs  | Low-Moderate   | 9800       | Payroll integrity   | Reconciliation  | Maeve     | Theron     | Attorney Ainsley  | attorney.ainsley.houde10@mailto.plus        | PrairieMotion Claims Studio     |
      
      
        @edit_terms_buyout
  Scenario Outline: Add Buyout after Contract Generation and verify in Edit Terms (no nulls)
    Given Buyout_Add_After_Contract_Generation_through_Edit_Terms with data:
      | Key                      | Value                |
      | Case.Case Type           | <CaseType>           |
      | Case.State               | <CaseState>          |
      | Case.Date of Incident    | <IncidentDate>       |
      | Case.Lead Source         | <LeadSource>         |
      | Case.Requested Amount    | <ReqAmount>          |
      | Case.Court Index Number  | <CourtIndex>         |
      | Case.Summary             | <Summary>            |

      | Case.Buyout Funder Name  | <BuyoutFunder>       |
      | Case.Buyout Amount       | <Buyout>             |
      | Case.Approved Amount     | <Approved>           |
      | Case.Document prep fee   | <PrepFee>            |
      | Case.Fund transfer fee   | <TransFee>           |
      | Case.Rate of Return      | <ROR>                |

      | Case.Agreement Date      | AUTO                 |
      | Case.Interest Start Date | AUTO                 |
      | Case.Buyout Expiry Date  | AUTO                 |

      | Plaintiff.First Name     | <PltfFirst>          |
      | Plaintiff.Last Name      | <PltfLast>           |

      | Attorney.First Name      | <AttrFirst>          |
      | Attorney.Email           | <AttrEmail>          |

      | LawFirm.Name             | <LFName>             |

      | Staff.Staff First Name   | Staff Nivaren        |
      | Staff.Staff Email        | staff.nivaren.thornwick25@mailto.plus |

      | Email.Template           | None                 |
      | Email.Subject            | Document Request     |
      | Email.To                 | intake@example.com   |
      | Email.Cc                 | cc@example.com       |
      | Email.Bcc                | bcc@example.com      |
      | Email.Message            | Hello,\n\nPlease upload required documents.\n\nThank you. |

    Examples:
      | CaseType            | CaseState      | IncidentDate | LeadSource   | ReqAmount | CourtIndex | Summary            | BuyoutFunder                         | Buyout | Approved | PrepFee | TransFee | ROR | PltfFirst | PltfLast   | AttrFirst         | AttrEmail                                    | LFName                          |
      | Premises Liability  | California     | 03/09/2024   | Advertising  | 73500     | 19CV-4921  | Slip on tile...    | Juniper Vale Litigation Capital       | 19600  | 31000    | 325     | 120      | 44  | Holden    | Glassford  | Attorney Maëlys   | attorney.maelys.beausoleil01@yopmail.com     | VerdictForge Litigation Atelier |
      | Discrimination      | Texas          | 11/14/2023   | Referral     | 59000     | 07CV-7113  | Demotion alleged   | Crownstone Settlement Finance         | 14800  | 24500    | 290     | 105      | 41  | Marston   | Cavendish  | Attorney Éloïse   | attorney.eloise.montpetit02@mailto.plus      | NorthStar Docketworks           |
      | Breach of contract  | New York       | 07/02/2023   | Broker       | 86000     | 31CV-9405  | Vendor dispute     | Obsidian Harbor Funding Partners      | 22400  | 36000    | 365     | 135      | 48  | Corinne   | Haverly    | Attorney Callum   | attorney.callum.kincaidrowe03@mailto.plus    | Cascade Claimcraft Legal Studio |
      | Dog Bite            | Florida        | 01/28/2024   | Medical      | 21000     | 11CV-6732  | Infection/scar     | Seabright Plaintiff Capital           | 5100   | 9200     | 215     | 75       | 33  | Bennett   | Ashbourne  | Attorney Siobhan  | attorney.siobhan.belanger04@mailto.plus      | Keystone Dispute Lab            |
      | Employment Disputes | Washington     | 09/18/2024   | Organic      | 45500     | 05CV-3118  | Retaliation        | Verdant Peak Litigation Finance       | 11200  | 19000    | 275     | 95       | 39  | Harper    | Morringate | Attorney Théodore | attorney.theodore.ducharme05@mailto.plus     | Peachtree Litigation Works      |
      | Workers Comp        | Ohio           | 10/03/2023   | Other        | 29500     | 18WC-5804  | Shoulder strain    | Ironleaf Recovery Capital             | 7200   | 12000    | 245     | 85       | 36  | Declan    | Kinsleigh  | Attorney Mireille | attorney.mireille.laframboise06@mailto.plus  | HarborLedger Trial Office       |
      | Negligence          | Colorado       | 04/12/2024   | Broker       | 51500     | 02CV-8219  | Tripped on ramp    | Stonegate Plaintiff Funding           | 12900  | 21000    | 285     | 100      | 40  | Amina     | Rahbourne  | Attorney Lachlan  | attorney.lachlan.macquarrie07@mailto.plus    | BayState Casebuilders           |
      | Property Damage     | Georgia        | 02/02/2024   | Organic      | 34000     | 09CV-1668  | Water intrusion    | Harborglint Legal Finance             | 8200   | 14500    | 255     | 90       | 37  | Rosalind  | Denwick    | Attorney Geneviève| attorney.genevieve.thibodeau08@mailto.plus   | MillCity Docket Foundry         |
      | Civil Rights        | Washington DC  | 08/17/2023   | Broker       | 66500     | 01CV-5331  | Battery fire       | Redwood Axis Litigation Finance       | 17400  | 29500    | 310     | 115      | 46  | Talia     | Kawson     | Attorney Étienne  | attorney.etienne.cormier11@mailto.plus       | FrontRange Trial Mechanics      |
      | Unpaid Wages        | Pennsylvania   | 12/05/2023   | Other        | 24000     | 17CV-1902  | Overtime unpaid    | Blue Lantern Funding Co.              | 5600   | 9800     | 225     | 75       | 34  | Maeve     | Theron     | Attorney Ainsley  | attorney.ainsley.houde10@mailto.plus         | PrairieMotion Claims Studio     |
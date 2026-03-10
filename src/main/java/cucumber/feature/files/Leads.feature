Feature: Frontend Apply Now Leads - reuse TestNG method frontend_form_filler

@applynow
Scenario Outline: Submit ApplyNow form dataset <Row>
  Given Frontend_ApplyNow with data:
    | Key | Value |
    | I am seeking an advance of | <I_am_seeking_an_advance_of> |
    | Your Full Name | <Your_Full_Name> |
    | Date of Birth | <Date_of_Birth> |
    | Phone Number | <Phone_Number> |
    | Email | <Email> |
    | Mailing Street Address | <Mailing_Street_Address> |
    | City | <City> |
    | State | <State> |
    | Lawyer's Name | <Lawyer_s_Name> |
    | Lawyer's Phone Number | <Lawyer_s_Phone_Number> |
    | Law Firm Name | <Law_Firm_Name> |
    | When did the accident happen? | <When_did_the_accident_happen> |
    | Where did the accident happen? | <Where_did_the_accident_happen> |
    | Describe the accident | <Describe_the_accident> |
    | Describe the injuries you sustained during the accident | <Describe_the_injuries_you_sustained_during_the_accident> |
    | Since your accident, have you been injured in any other traumatic incidents? | <Since_your_accident_have_you_been_injured_in_any_other_traum> |
    | Explain (Other Traumatic Incidents) | <Explain_Other_Traumatic_Incidents> |
    | In the 5 years before the accident, did you have a violation for no auto insurance? | <In_the_5_years_before_the_accident_did_you_have_a_violation_> |
    | Explain (No Auto Insurance Violation) | <Explain_No_Auto_Insurance_Violation> |
    | In the PRESENT accident, were you in a vehicle owned by you? | <In_the_PRESENT_accident_were_you_in_a_vehicle_owned_by_you> |
    | Was that vehicle covered by insurance? | <Was_that_vehicle_covered_by_insurance> |
    | Have you previously received a settlement advance for this case? | <Have_you_previously_received_a_settlement_advance_for_this_c> |
    | Explain (Previous Settlement Advance) | <Explain_Previous_Settlement_Advance> |
    | What company did you borrow from? | <What_company_did_you_borrow_from> |
    | How much did you receive? | <How_much_did_you_receive> |
    | Were other people injured in this accident? | <Were_other_people_injured_in_this_accident> |
    | Explain (Other People Injured) | <Explain_Other_People_Injured> |
    | Are you currently behind on child support? | <Are_you_currently_behind_on_child_support> |
    | Explain (Behind on Child Support) | <Explain_Behind_on_Child_Support> |
    | Where do you owe child support? (State) | <Where_do_you_owe_child_support_State> |
    | Where do you owe child support? (County) | <Where_do_you_owe_child_support_County> |
    | How much do you owe? | <How_much_do_you_owe> |
    | Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage? | <Are_you_Enrolled_in_Medicare_Medicaid_or_any_other_government> |
    | Which one(s)? | <Which_one_s> |
    | Explain (Governmental Health Coverage) | <Explain_Governmental_Health_Coverage> |

  Examples:
    | Row | I_am_seeking_an_advance_of | Your_Full_Name | Date_of_Birth | Phone_Number | Email | Mailing_Street_Address | City | State | Lawyer_s_Name | Lawyer_s_Phone_Number | Law_Firm_Name | When_did_the_accident_happen | Where_did_the_accident_happen | Describe_the_accident | Describe_the_injuries_you_sustained_during_the_accident | Since_your_accident_have_you_been_injured_in_any_other_traum | Explain_Other_Traumatic_Incidents | In_the_5_years_before_the_accident_did_you_have_a_violation_ | Explain_No_Auto_Insurance_Violation | In_the_PRESENT_accident_were_you_in_a_vehicle_owned_by_you | Was_that_vehicle_covered_by_insurance | Have_you_previously_received_a_settlement_advance_for_this_c | Explain_Previous_Settlement_Advance | What_company_did_you_borrow_from | How_much_did_you_receive | Were_other_people_injured_in_this_accident | Explain_Other_People_Injured | Are_you_currently_behind_on_child_support | Explain_Behind_on_Child_Support | Where_do_you_owe_child_support_State | Where_do_you_owe_child_support_County | How_much_do_you_owe | Are_you_Enrolled_in_Medicare_Medicaid_or_any_other_government | Which_one_s | Explain_Governmental_Health_Coverage |
    | 1 | 16250 | @Test_Kieran Holt | 03/19/1992 | 9176614028 | pltf.kieran.holt.1a7k9m2q@yopmail.com | 418 Madison Avenue, Apt 9B | Syracuse | New York | Daniel Palmer | 6467721180 | Capitol Briefworks | 10/08/2024 | Syracuse, NY | Rear-end collision in stop-and-go traffic. The vehicle behind failed to brake in time and pushed my car forward. Photos were taken of damage, lane markings, and nearby signage. Added length to verify wrapping and saved preview stability. | Neck stiffness later that evening, mild headache, and upper-back tightness. Walk-in clinic advised rest and follow-up if symptoms persist. | NO |  | YES | Short policy gap during provider switch; reinstated quickly. Incident recorded as citation during the gap. |  |  | NO |  |  |  |  | NO |  | NO |  |  |  |  |  |  |
    | 2 | 7800 | @Test_Amelia Pierce | 08/11/1996 | 6467713904 | pltf.amelia.pierce.2b1m7tqk@yopmail.com | 12 Bay Street, Unit 14 | Rochester | New York |  |  |  | 11/15/2024 | Rochester, NY | Side-impact collision at an intersection. Other vehicle ran a red light. Police report filed; intersection camera noted. | Shoulder pain and bruising, reduced range of motion for several days. | NO |  | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 3 | 12500 | @Test_Owen Carter | 01/04/1990 | 7186629107 | pltf.owen.carter.3c8p1nqz@yopmail.com | 55 Lexington Ave, Floor 3 | Albany | New York | Mariah Benson | 9175559011 | NorthStar Docketworks | 09/03/2024 | Albany, NY | Highway merge collision; adjacent vehicle merged into my lane without clearance. | Lower back soreness and stiffness; ongoing physiotherapy sessions. | YES | Minor slip-and-fall at work 2 years ago, no lasting injury. | NO |  |  |  | YES | Borrowed once before for a different matter; fully repaid. | Legacy Advance Co | 2200 | NO |  | NO |  |  |  |  |  |  ||
    | 4 | 9500 | @Test_Evelyn Shaw | 06/23/1994 | 9294401183 | pltf.evelyn.shaw.4d2r9mxa@yopmail.com | 760 Grand Concourse, Apt 21C | Bronx | New York |  |  |  | 12/20/2024 | Bronx, NY | Rear bumper hit in a parking lot; other driver admitted fault on-site. | Mild whiplash and headaches for 3 days. | NO |  | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 5 | 18000 | @Test_Liam Brooks | 02/16/1988 | 3472017739 | pltf.liam.brooks.5e4v7kqp@yopmail.com | 200 W 57th St, Apt 8A | New York | New York | Derek Lane | 6463337771 | MillCity Docket Foundry | 07/29/2024 | Manhattan, NY | Multi-car chain reaction; I was the third car impacted. | Neck strain and numbness in right arm intermittently. | NO |  | YES | Lapse due to billing issue; resolved next day. |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 6 | 6400 | @Test_Hannah Reed | 10/02/1997 | 6467789921 | pltf.hannah.reed.6f2q8nrm@yopmail.com | 890 Elmwood Ave, Unit 2 | Buffalo | New York |  |  |  | 10/01/2024 | Buffalo, NY | Hit from behind at traffic light; other driver distracted. | Neck pain and upper-back tightness, improving. | NO |  | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 7 | 11200 | @Test_Noah Griffin | 04/30/1993 | 9176011144 | pltf.noah.griffin.7g5t0mza@yopmail.com | 14 Water St, Apt 5 | Utica | New York |  |  |  | 08/19/2024 | Utica, NY | Side-swipe while parked; driver fled. | Shoulder bruising and stress. | NO |  | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 8 | 21000 | @Test_Sophia Klein | 09/14/1991 | 6468120098 | pltf.sophia.klein.8h1v9qpl@yopmail.com | 311 5th Ave, Suite 900 | New York | New York | Aria Patel | 6462007744 | PrairieMotion Claims Studio | 05/06/2024 | Queens, NY | Intersection collision; other vehicle failed to yield. | Knee sprain; ongoing pain with stairs. | YES | Prior sports injury in college; no ongoing treatment. | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 9 | 7300 | @Test_Emily Vaughn | 12/09/1995 | 3478891120 | pltf.emily.vaughn.9i0c2nrb@yopmail.com | 900 Broadway, Apt 11D | Brooklyn | New York |  |  |  | 11/30/2024 | Brooklyn, NY | Low speed crash in residential lane; other driver reversed unexpectedly. | Minor neck pain, resolved in 2 days. | NO |  | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 10 | 15800 | @Test_Mason Pike | 07/07/1989 | 9174438201 | pltf.mason.pike.10j4m9xz@yopmail.com | 77 King St, Apt 3 | Schenectady | New York |  |  |  | 09/22/2024 | Schenectady, NY | Rear end collision near exit ramp; heavy traffic. | Neck and shoulder pain, physio recommended. | NO |  | YES | Temporary lapse; corrected. |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 11 | 6200 | @Test_Grace Nolan | 11/21/1998 | 6469912287 | pltf.grace.nolan.11k8p2qa@yopmail.com | 200 Main St, Unit 7 | Ithaca | New York |  |  |  | 10/17/2024 | Ithaca, NY | Hit by a turning vehicle; reported on scene. | Wrist sprain and bruising. | NO |  | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 12 | 19800 | @Test_Ethan Rowe | 05/13/1987 | 3472201199 | pltf.ethan.rowe.12l6t1qm@yopmail.com | 14 2nd St, Apt 1A | New York | New York |  |  |  | 06/11/2024 | Staten Island, NY | Accident in roundabout; driver cut lane. | Back pain; MRI scheduled. | NO |  | NO |  |  |  | YES | Previous small advance for same case; repaid. | Riverline Funding | 1800 | NO |  | NO |  |  |  |  |  |  ||
    | 13 | 5400 | @Test_Ava Quinn | 03/02/1999 | 6467318891 | pltf.ava.quinn.13m5v0zn@yopmail.com | 600 Orchard St, Apt 2 | Yonkers | New York |  |  |  | 12/12/2024 | Yonkers, NY | Vehicle rear bumped while merging. | Mild back pain. | NO |  | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 14 | 16600 | @Test_Logan Avery | 02/25/1990 | 9172224400 | pltf.logan.avery.14n9q3xm@yopmail.com | 79 Court St, Apt 9 | Binghamton | New York |  |  |  | 08/10/2024 | Binghamton, NY | Side impact at stop sign; other driver distracted. | Shoulder injury; PT ongoing. | YES | Minor fall last year; no treatment required. | NO |  |  |  | NO |  |  |  | YES | Not behind, but had past delay resolved. |  |  |  |  |  ||||
    | 15 | 8800 | @Test_Isla Benton | 04/09/1996 | 6468801123 | pltf.isla.benton.15p1m7qa@yopmail.com | 240 Lake Ave, Unit 4 | Poughkeepsie | New York |  |  |  | 09/29/2024 | Poughkeepsie, NY | Rear end on wet road; skid caused collision. | Neck pain, headache. | NO |  | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 16 | 12000 | @Test_Caleb Mason | 01/19/1992 | 9178821109 | pltf.caleb.mason.16q0n4xm@yopmail.com | 510 Spring St, Apt 10 | New York | New York |  |  |  | 07/04/2024 | Queens, NY | Accident at intersection; T-bone crash. | Knee and back pain. | NO |  | YES | Lapse due to move; fixed. |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 17 | 7600 | @Test_Mia Turner | 10/28/1997 | 6469201188 | pltf.mia.turner.17r3m9qa@yopmail.com | 16 River Rd, Apt 2 | Troy | New York |  |  |  | 11/02/2024 | Troy, NY | Rear end at signal. | Mild neck strain. | NO |  | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 18 | 20500 | @Test_Levi Harrison | 06/01/1986 | 3477712209 | pltf.levi.harrison.18s1q8xz@yopmail.com | 98 Pine St, Apt 6 | New York | New York | Olivia Blake | 6468889900 | SunCoast Liability Atelier | 05/18/2024 | New York, NY | Multi vehicle collision in tunnel; traffic halted. | Whiplash and lower back pain. | NO |  | NO |  |  |  | YES | Prior advance for same case. | Apex Capital | 2500 | NO |  | NO |  |  |  |  |  |  ||
    | 19 | 6900 | @Test_Clara Morris | 09/09/1998 | 6465107788 | pltf.clara.morris.19t7n2xm@yopmail.com | 41 State St, Unit 8 | New Rochelle | New York |  |  |  | 10/26/2024 | New Rochelle, NY | Low speed collision at driveway entry. | Bruising and soreness. | NO |  | NO |  |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    | 20 | 15000 | @Test_Sadie Harper | 12/31/1991 | 9174401122 | pltf.sadie.harper.20u2m9qa@yopmail.com | 780 Park Ave, Apt 3 | New York | New York |  |  |  | 08/28/2024 | New York, NY | Rear end accident; driver behind distracted. | Neck pain; follow-up scheduled. | NO |  | YES | Brief gap; corrected. |  |  | NO |  |  |  | NO |  | NO |  |  |  |  |  |  ||
    
    
    @leadsadmin
Scenario: Read lead list, click target lead, capture details using TestNG method
  Given Lead_List_Data_Reader_and_clicker
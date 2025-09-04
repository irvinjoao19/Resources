package com.gongora.resources.demo.domain.usecases

import com.gongora.resources.demo.domain.models.IconToken
import com.gongora.resources.tokens.Icons

/**
 * Use case for retrieving and organizing icon tokens by categories.
 * 
 * This use case follows the same pattern as GetColorTokensUseCase,
 * directly accessing the tokens from the resources library.
 */
class GetIconsUseCase {
    
    /**
     * Executes the use case and returns icon tokens organized by categories.
     * @return Map of icon categories to their respective tokens
     */
    operator fun invoke(): Map<String, List<IconToken>> {
        val categories = mutableMapOf<String, MutableList<IconToken>>()
        
        // Communication icons
        categories["Communication"] = mutableListOf(
            IconToken("mail", Icons.Communication.mail, "Mail", "Communication"),
            IconToken("message", Icons.Communication.message, "Message", "Communication"),
            IconToken("telephone", Icons.Communication.telephone, "Telephone", "Communication"),
            IconToken("smartphone", Icons.Communication.smartphone, "Smartphone", "Communication"),
            IconToken("smartphoneCall", Icons.Communication.smartphoneCall, "Smartphone Call", "Communication"),
            IconToken("smartphoneIncomingCall", Icons.Communication.smartphoneIncomingCall, "Smartphone Incoming Call", "Communication"),
            IconToken("microphone", Icons.Communication.microphone, "Microphone", "Communication"),
            IconToken("megaphone", Icons.Communication.megaphone, "Megaphone", "Communication"),
            IconToken("headphone", Icons.Communication.headphone, "Headphone", "Communication"),
            IconToken("share", Icons.Communication.share, "Share", "Communication"),
            IconToken("paperPlaneRight", Icons.Communication.paperPlaneRight, "Paper Plane Right", "Communication"),
            IconToken("paperPlaneUp", Icons.Communication.paperPlaneUp, "Paper Plane Up", "Communication"),
            IconToken("circleConnection", Icons.Communication.circleConnection, "Circle Connection", "Communication")
        )
        
        // Documents icons
        categories["Documents"] = mutableListOf(
            IconToken("document", Icons.Document.filesDocument, "Document", "Documents"),
            IconToken("documentApproved", Icons.Document.filesDocumentApproved, "Document Approved", "Documents"),
            IconToken("documentDenied", Icons.Document.filesDocumentDenied, "Document Denied", "Documents"),
            IconToken("documentPlus", Icons.Document.filesDocumentPlus, "Document Plus", "Documents"),
            IconToken("documentLess", Icons.Document.filesDocumentLess, "Document Less", "Documents"),
            IconToken("documentPencil", Icons.Document.filesDocumentPencil, "Document Pencil", "Documents"),
            IconToken("documentCard", Icons.Document.filesDocumentCard, "Document Card", "Documents"),
            IconToken("documents", Icons.Document.filesDocuments, "Documents", "Documents"),
            IconToken("archive", Icons.Document.filesArchive, "Archive", "Documents"),
            IconToken("excel", Icons.Document.filesExcel, "Excel", "Documents"),
            IconToken("pdf", Icons.Document.filesPdf, "PDF", "Documents"),
            IconToken("copy", Icons.Document.filesCopy, "Copy", "Documents"),
            IconToken("edit", Icons.Document.filesEdit, "Edit", "Documents"),
            IconToken("folder", Icons.Document.filesFolder, "Folder", "Documents"),
            IconToken("paperclip", Icons.Document.filesPaperclip, "Paperclip", "Documents"),
            IconToken("pen", Icons.Document.filesPen, "Pen", "Documents"),
            IconToken("fountainPen", Icons.Document.filesFountainPen, "Fountain Pen", "Documents"),
            IconToken("id", Icons.Document.filesId, "ID", "Documents"),
            IconToken("idcard", Icons.Document.filesIdcard, "ID Card", "Documents")
        )
        
        // Finances icons
        categories["Finances"] = mutableListOf(
            IconToken("bank", Icons.Finances.paymentsBank, "Bank", "Finances"),
            IconToken("atm", Icons.Finances.paymentsAtm, "ATM", "Finances"),
            IconToken("atmScreen", Icons.Finances.paymentsAtmScreen, "ATM Screen", "Finances"),
            IconToken("badgePercent", Icons.Finances.paymentsBadgePercent, "Badge Percent", "Finances"),
            IconToken("chartBar", Icons.Finances.paymentsChartBar, "Chart Bar", "Finances"),
            IconToken("bill", Icons.Finances.paymentsBill, "Bill", "Finances"),
            IconToken("cards", Icons.Finances.paymentsCards, "Cards", "Finances")
        )
        
        // Emotions icons
        categories["Emotions"] = mutableListOf(
            IconToken("faceHappy", Icons.Emotions.reactionsFaceHappy, "Happy Face", "Emotions"),
            IconToken("faceSad", Icons.Emotions.reactionsFaceSad, "Sad Face", "Emotions"),
            IconToken("faceAngry", Icons.Emotions.reactionsFaceAngry, "Angry Face", "Emotions"),
            IconToken("faceSatisfied", Icons.Emotions.reactionsFaceSatisfied, "Satisfied Face", "Emotions"),
            IconToken("faceSerious", Icons.Emotions.reactionsFaceSerious, "Serious Face", "Emotions"),
            IconToken("handLike", Icons.Emotions.reactionsHandLike, "Hand Like", "Emotions"),
            IconToken("handDislike", Icons.Emotions.reactionsHandDislike, "Hand Dislike", "Emotions"),
            IconToken("handHolding", Icons.Emotions.reactionsHandHolding, "Hand Holding", "Emotions"),
            IconToken("heart", Icons.Emotions.reactionsHeart, "Heart", "Emotions"),
            IconToken("heartSlash", Icons.Emotions.reactionsHeartSlash, "Heart Slash", "Emotions")
        )
        
        // E-Commerce icons
        categories["E-Commerce"] = mutableListOf(
            IconToken("shoppingCar", Icons.E.commerceShoppingShoppingCar, "Shopping Car", "E-Commerce"),
            IconToken("shoppingBag", Icons.E.commerceShoppingShoppingBag, "Shopping Bag", "E-Commerce"),
            IconToken("store", Icons.E.commerceShoppingStore, "Store", "E-Commerce"),
            IconToken("storeClock", Icons.E.commerceShoppingStoreClock, "Store Clock", "E-Commerce"),
            IconToken("box", Icons.E.commerceShoppingBox, "Box", "E-Commerce"),
            IconToken("gift", Icons.E.commerceShoppingGift, "Gift", "E-Commerce"),
            IconToken("star", Icons.E.commerceShoppingStar, "Star", "E-Commerce"),
            IconToken("trophy", Icons.E.commerceShoppingTrophy, "Trophy", "E-Commerce"),
            IconToken("tag", Icons.E.commerceShoppingTag, "Tag", "E-Commerce"),
            IconToken("label", Icons.E.commerceShoppingLabel, "Label", "E-Commerce"),
            IconToken("ticket", Icons.E.commerceShoppingTicket, "Ticket", "E-Commerce"),
            IconToken("gavel", Icons.E.commerceShoppingGavel, "Gavel", "E-Commerce"),
            IconToken("clotheHanger", Icons.E.commerceShoppingClotheHanger, "Clothe Hanger", "E-Commerce")
        )
        
        // Navigation icons
        categories["Navigation"] = mutableListOf(
            IconToken("arrowLeft", Icons.Navigation.arrowLeft, "Arrow Left", "Navigation"),
            IconToken("arrowRight", Icons.Navigation.arrowRight, "Arrow Right", "Navigation"),
            IconToken("close", Icons.Navigation.close, "Close", "Navigation"),
            IconToken("interfaceArrowDown", Icons.Navigation.interfaceArrowDown, "Arrow Down", "Navigation"),
            IconToken("interfaceArrowLeft", Icons.Navigation.interfaceArrowLeft, "Arrow Left", "Navigation"),
            IconToken("interfaceArrowRight", Icons.Navigation.interfaceArrowRight, "Arrow Right", "Navigation"),
            IconToken("interfaceArrowUp", Icons.Navigation.interfaceArrowUp, "Arrow Up", "Navigation"),
            IconToken("interfaceChevronDown", Icons.Navigation.interfaceChevronDown, "Chevron Down", "Navigation"),
            IconToken("interfaceChevronLeft", Icons.Navigation.interfaceChevronLeft, "Chevron Left", "Navigation"),
            IconToken("interfaceChevronRight", Icons.Navigation.interfaceChevronRight, "Chevron Right", "Navigation"),
            IconToken("interfaceChevronUp", Icons.Navigation.interfaceChevronUp, "Chevron Up", "Navigation"),
            IconToken("interfaceClose", Icons.Navigation.interfaceClose, "Close", "Navigation"),
            IconToken("interfaceExpand", Icons.Navigation.interfaceExpand, "Expand", "Navigation"),
            IconToken("interfaceMenu", Icons.Navigation.interfaceMenu, "Menu", "Navigation"),
            IconToken("interfacePlus", Icons.Navigation.interfacePlus, "Plus", "Navigation"),
            IconToken("interfaceMinus", Icons.Navigation.interfaceMinus, "Minus", "Navigation")
        )
        
        // Security icons
        categories["Security"] = mutableListOf(
            IconToken("eye", Icons.Security.eye, "Eye", "Security"),
            IconToken("eyeSlash", Icons.Security.eyeSlash, "Eye Slash", "Security"),
            IconToken("faceid", Icons.Security.faceid, "Face ID", "Security"),
            IconToken("fingerprint", Icons.Security.fingerprint, "Fingerprint", "Security"),
            IconToken("key", Icons.Security.key, "Key", "Security"),
            IconToken("lock", Icons.Security.lock, "Lock", "Security"),
            IconToken("lockOpen", Icons.Security.lockOpen, "Lock Open", "Security"),
            IconToken("shield", Icons.Security.shield, "Shield", "Security"),
            IconToken("safeBox", Icons.Security.safeBox, "Safe Box", "Security")
        )
        
        // People icons
        categories["People"] = mutableListOf(
            IconToken("man", Icons.People.communityMan, "Man", "People"),
            IconToken("manCircle", Icons.People.communityManCircle, "Man Circle", "People"),
            IconToken("manGroup", Icons.People.communityManGroup, "Man Group", "People"),
            IconToken("manGroup3", Icons.People.communityManGroup3, "Man Group 3", "People"),
            IconToken("manPlus", Icons.People.communityManPlus, "Man Plus", "People"),
            IconToken("persons", Icons.People.communityPersons, "Persons", "People"),
            IconToken("woman", Icons.People.communityWoman, "Woman", "People"),
            IconToken("womanGroup", Icons.People.communityWomanGroup, "Woman Group", "People")
        )
        
        // Payment icons
        categories["Payment"] = mutableListOf(
            IconToken("cardApproved", Icons.Payment.cardsCardApproved, "Card Approved", "Payment"),
            IconToken("cardChange", Icons.Payment.cardsCardChange, "Card Change", "Payment"),
            IconToken("cardCredit", Icons.Payment.cardsCardCredit, "Card Credit", "Payment"),
            IconToken("cardCreditDigital", Icons.Payment.cardsCardCreditDigital, "Card Credit Digital", "Payment"),
            IconToken("cardDenied", Icons.Payment.cardsCardDenied, "Card Denied", "Payment"),
            IconToken("cardGear", Icons.Payment.cardsCardGear, "Card Gear", "Payment"),
            IconToken("cardHidden", Icons.Payment.cardsCardHidden, "Card Hidden", "Payment"),
            IconToken("cardLess", Icons.Payment.cardsCardLess, "Card Less", "Payment"),
            IconToken("cardPlus", Icons.Payment.cardsCardPlus, "Card Plus", "Payment")
        )
        
        // Flags icons - ALL FLAGS
        categories["Flags"] = mutableListOf(
//            IconToken("ic_flags_albania", Icons.Flags.albania, "Albania", "Flags"),
//            IconToken("ic_flags_algeria", Icons.Flags.algeria, "Algeria", "Flags"),
            IconToken("ic_flags_andorra", Icons.Flags.andorra, "Andorra", "Flags"),
//            IconToken("ic_flags_angola", Icons.Flags.angola, "Angola", "Flags"),
//            IconToken("ic_flags_antigua_and_barbuda", Icons.Flags.antiguaAndBarbuda, "Antigua and Barbuda", "Flags"),
//            IconToken("ic_flags_argentina", Icons.Flags.argentina, "Argentina", "Flags"),
//            IconToken("ic_flags_aruba", Icons.Flags.aruba, "Aruba", "Flags"),
//            IconToken("ic_flags_austria", Icons.Flags.austria, "Austria", "Flags"),
//            IconToken("ic_flags_bahamas", Icons.Flags.bahamas, "Bahamas", "Flags"),
//            IconToken("ic_flags_barbados", Icons.Flags.barbados, "Barbados", "Flags"),
//            IconToken("ic_flags_belarus", Icons.Flags.belarus, "Belarus", "Flags"),
//            IconToken("ic_flags_belgium", Icons.Flags.belgium, "Belgium", "Flags"),
//            IconToken("ic_flags_belize", Icons.Flags.belize, "Belize", "Flags"),
//            IconToken("ic_flags_benin", Icons.Flags.benin, "Benin", "Flags"),
//            IconToken("ic_flags_bolivia", Icons.Flags.bolivia, "Bolivia", "Flags"),
//            IconToken("ic_flags_bosnia_and_herzegovina", Icons.Flags.bosniaAndHerzegovina, "Bosnia and Herzegovina", "Flags"),
//            IconToken("ic_flags_botswana", Icons.Flags.botswana, "Botswana", "Flags"),
//            IconToken("ic_flags_brazil", Icons.Flags.brazil, "Brazil", "Flags"),
//            IconToken("ic_flags_bulgaria", Icons.Flags.bulgaria, "Bulgaria", "Flags"),
//            IconToken("ic_flags_burkina_faso", Icons.Flags.burkinaFaso, "Burkina Faso", "Flags"),
//            IconToken("ic_flags_burundi", Icons.Flags.burundi, "Burundi", "Flags"),
//            IconToken("ic_flags_cameroon", Icons.Flags.cameroon, "Cameroon", "Flags"),
//            IconToken("ic_flags_canada", Icons.Flags.canada, "Canada", "Flags"),
//            IconToken("ic_flags_cape_verde", Icons.Flags.capeVerde, "Cape Verde", "Flags"),
//            IconToken("ic_flags_cayman_islands", Icons.Flags.caymanIslands, "Cayman Islands", "Flags"),
//            IconToken("ic_flags_central_african_republic", Icons.Flags.centralAfricanRepublic, "Central African Republic", "Flags"),
//            IconToken("ic_flags_chad", Icons.Flags.chad, "Chad", "Flags"),
//            IconToken("ic_flags_chile", Icons.Flags.chile, "Chile", "Flags"),
//            IconToken("ic_flags_colombia", Icons.Flags.colombia, "Colombia", "Flags"),
//            IconToken("ic_flags_comoros", Icons.Flags.comoros, "Comoros", "Flags"),
//            IconToken("ic_flags_congo", Icons.Flags.congo, "Congo", "Flags"),
//            IconToken("ic_flags_costa_rica", Icons.Flags.costaRica, "Costa Rica", "Flags"),
//            IconToken("ic_flags_croatia", Icons.Flags.croatia, "Croatia", "Flags"),
//            IconToken("ic_flags_cuba", Icons.Flags.cuba, "Cuba", "Flags"),
//            IconToken("ic_flags_curacao", Icons.Flags.curacao, "Curacao", "Flags"),
//            IconToken("ic_flags_cyprus", Icons.Flags.cyprus, "Cyprus", "Flags"),
//            IconToken("ic_flags_czechia", Icons.Flags.czechia, "Czechia", "Flags"),
//            IconToken("ic_flags_democratic_republic_of_the_congo", Icons.Flags.democraticRepublicOfTheCongo, "Democratic Republic of the Congo", "Flags"),
//            IconToken("ic_flags_denmark", Icons.Flags.denmark, "Denmark", "Flags"),
//            IconToken("ic_flags_djibouti", Icons.Flags.djibouti, "Djibouti", "Flags"),
//            IconToken("ic_flags_dominica", Icons.Flags.dominica, "Dominica", "Flags"),
//            IconToken("ic_flags_dominican_republic", Icons.Flags.dominicanRepublic, "Dominican Republic", "Flags"),
//            IconToken("ic_flags_ecuador", Icons.Flags.ecuador, "Ecuador", "Flags"),
//            IconToken("ic_flags_egypt", Icons.Flags.egypt, "Egypt", "Flags"),
//            IconToken("ic_flags_el_salvador", Icons.Flags.elSalvador, "El Salvador", "Flags"),
//            IconToken("ic_flags_equatorial_guinea", Icons.Flags.equatorialGuinea, "Equatorial Guinea", "Flags"),
//            IconToken("ic_flags_eritrea", Icons.Flags.eritrea, "Eritrea", "Flags"),
//            IconToken("ic_flags_estonia", Icons.Flags.estonia, "Estonia", "Flags"),
//            IconToken("ic_flags_eswatini", Icons.Flags.eswatini, "Eswatini", "Flags"),
//            IconToken("ic_flags_ethiopia", Icons.Flags.ethiopia, "Ethiopia", "Flags"),
//            IconToken("ic_flags_european_union", Icons.Flags.europeanUnion, "European Union", "Flags"),
//            IconToken("ic_flags_falkland_islands", Icons.Flags.falklandIslands, "Falkland Islands", "Flags"),
//            IconToken("ic_flags_finland", Icons.Flags.finland, "Finland", "Flags"),
//            IconToken("ic_flags_france", Icons.Flags.france, "France", "Flags"),
//            IconToken("ic_flags_french_guiana", Icons.Flags.frenchGuiana, "French Guiana", "Flags"),
//            IconToken("ic_flags_gabon", Icons.Flags.gabon, "Gabon", "Flags"),
//            IconToken("ic_flags_gambia", Icons.Flags.gambia, "Gambia", "Flags"),
//            IconToken("ic_flags_germany", Icons.Flags.germany, "Germany", "Flags"),
//            IconToken("ic_flags_ghana", Icons.Flags.ghana, "Ghana", "Flags"),
//            IconToken("ic_flags_gibraltar", Icons.Flags.gibraltar, "Gibraltar", "Flags"),
//            IconToken("ic_flags_greece", Icons.Flags.greece, "Greece", "Flags"),
//            IconToken("ic_flags_greenland", Icons.Flags.greenland, "Greenland", "Flags"),
//            IconToken("ic_flags_grenada", Icons.Flags.grenada, "Grenada", "Flags"),
//            IconToken("ic_flags_guatemala", Icons.Flags.guatemala, "Guatemala", "Flags"),
//            IconToken("ic_flags_guernsey", Icons.Flags.guernsey, "Guernsey", "Flags"),
//            IconToken("ic_flags_guinea", Icons.Flags.guinea, "Guinea", "Flags"),
//            IconToken("ic_flags_guinea_bissau", Icons.Flags.guineaBissau, "Guinea Bissau", "Flags"),
//            IconToken("ic_flags_guyana", Icons.Flags.guyana, "Guyana", "Flags"),
//            IconToken("ic_flags_haiti", Icons.Flags.haiti, "Haiti", "Flags"),
//            IconToken("ic_flags_honduras", Icons.Flags.honduras, "Honduras", "Flags"),
//            IconToken("ic_flags_hungary", Icons.Flags.hungary, "Hungary", "Flags"),
//            IconToken("ic_flags_iceland", Icons.Flags.iceland, "Iceland", "Flags"),
//            IconToken("ic_flags_ireland", Icons.Flags.ireland, "Ireland", "Flags"),
//            IconToken("ic_flags_isle_of_man", Icons.Flags.isleOfMan, "Isle of Man", "Flags"),
//            IconToken("ic_flags_italy", Icons.Flags.italy, "Italy", "Flags"),
//            IconToken("ic_flags_ivory_coast", Icons.Flags.ivoryCoast, "Ivory Coast", "Flags"),
//            IconToken("ic_flags_jamaica", Icons.Flags.jamaica, "Jamaica", "Flags"),
//            IconToken("ic_flags_jersey", Icons.Flags.jersey, "Jersey", "Flags"),
//            IconToken("ic_flags_kenya", Icons.Flags.kenya, "Kenya", "Flags"),
//            IconToken("ic_flags_kosovo", Icons.Flags.kosovo, "Kosovo", "Flags"),
//            IconToken("ic_flags_latvia", Icons.Flags.latvia, "Latvia", "Flags"),
//            IconToken("ic_flags_lesotho", Icons.Flags.lesotho, "Lesotho", "Flags"),
//            IconToken("ic_flags_liberia", Icons.Flags.liberia, "Liberia", "Flags"),
//            IconToken("ic_flags_libya", Icons.Flags.libya, "Libya", "Flags"),
//            IconToken("ic_flags_liechtenstein", Icons.Flags.liechtenstein, "Liechtenstein", "Flags"),
//            IconToken("ic_flags_lithuania", Icons.Flags.lithuania, "Lithuania", "Flags"),
//            IconToken("ic_flags_luxembourg", Icons.Flags.luxembourg, "Luxembourg", "Flags"),
//            IconToken("ic_flags_macedonia", Icons.Flags.macedonia, "Macedonia", "Flags"),
//            IconToken("ic_flags_madagascar", Icons.Flags.madagascar, "Madagascar", "Flags"),
//            IconToken("ic_flags_malawi", Icons.Flags.malawi, "Malawi", "Flags"),
//            IconToken("ic_flags_mali", Icons.Flags.mali, "Mali", "Flags"),
//            IconToken("ic_flags_malta", Icons.Flags.malta, "Malta", "Flags"),
//            IconToken("ic_flags_mauritania", Icons.Flags.mauritania, "Mauritania", "Flags"),
//            IconToken("ic_flags_mauritius", Icons.Flags.mauritius, "Mauritius", "Flags"),
//            IconToken("ic_flags_mexico", Icons.Flags.mexico, "Mexico", "Flags"),
//            IconToken("ic_flags_moldova", Icons.Flags.moldova, "Moldova", "Flags"),
//            IconToken("ic_flags_monaco", Icons.Flags.monaco, "Monaco", "Flags"),
//            IconToken("ic_flags_montenegro", Icons.Flags.montenegro, "Montenegro", "Flags"),
//            IconToken("ic_flags_morocco", Icons.Flags.morocco, "Morocco", "Flags"),
//            IconToken("ic_flags_mozambique", Icons.Flags.mozambique, "Mozambique", "Flags"),
//            IconToken("ic_flags_namibia", Icons.Flags.namibia, "Namibia", "Flags"),
//            IconToken("ic_flags_netherlands", Icons.Flags.netherlands, "Netherlands", "Flags"),
//            IconToken("ic_flags_nicaragua", Icons.Flags.nicaragua, "Nicaragua", "Flags"),
//            IconToken("ic_flags_niger", Icons.Flags.niger, "Niger", "Flags"),
//            IconToken("ic_flags_nigeria", Icons.Flags.nigeria, "Nigeria", "Flags"),
//            IconToken("ic_flags_norway", Icons.Flags.norway, "Norway", "Flags"),
//            IconToken("ic_flags_panama", Icons.Flags.panama, "Panama", "Flags"),
//            IconToken("ic_flags_paraguay", Icons.Flags.paraguay, "Paraguay", "Flags"),
//            IconToken("ic_flags_peru", Icons.Flags.peru, "Peru", "Flags"),
//            IconToken("ic_flags_poland", Icons.Flags.poland, "Poland", "Flags"),
//            IconToken("ic_flags_portugal", Icons.Flags.portugal, "Portugal", "Flags"),
//            IconToken("ic_flags_puerto_rico", Icons.Flags.puertoRico, "Puerto Rico", "Flags"),
//            IconToken("ic_flags_romania", Icons.Flags.romania, "Romania", "Flags"),
//            IconToken("ic_flags_russia", Icons.Flags.russia, "Russia", "Flags"),
//            IconToken("ic_flags_rwanda", Icons.Flags.rwanda, "Rwanda", "Flags"),
//            IconToken("ic_flags_sahrawi_arab_democratic_republic", Icons.Flags.sahrawiArabDemocraticRepublic, "Sahrawi Arab Democratic Republic", "Flags"),
//            IconToken("ic_flags_saint_kitts_and_nevis", Icons.Flags.saintKittsAndNevis, "Saint Kitts and Nevis", "Flags"),
//            IconToken("ic_flags_saint_lucia", Icons.Flags.saintLucia, "Saint Lucia", "Flags"),
//            IconToken("ic_flags_saint_marten", Icons.Flags.saintMarten, "Saint Marten", "Flags"),
//            IconToken("ic_flags_san_marino", Icons.Flags.sanMarino, "San Marino", "Flags"),
//            IconToken("ic_flags_sao_tome_and_principe", Icons.Flags.saoTomeAndPrincipe, "Sao Tome and Principe", "Flags"),
//            IconToken("ic_flags_sark", Icons.Flags.sark, "Sark", "Flags"),
//            IconToken("ic_flags_senegal", Icons.Flags.senegal, "Senegal", "Flags"),
//            IconToken("ic_flags_serbia", Icons.Flags.serbia, "Serbia", "Flags"),
//            IconToken("ic_flags_seychelles", Icons.Flags.seychelles, "Seychelles", "Flags"),
//            IconToken("ic_flags_sierra_leone", Icons.Flags.sierraLeone, "Sierra Leone", "Flags"),
//            IconToken("ic_flags_slovakia", Icons.Flags.slovakia, "Slovakia", "Flags"),
//            IconToken("ic_flags_slovenia", Icons.Flags.slovenia, "Slovenia", "Flags"),
//            IconToken("ic_flags_somalia", Icons.Flags.somalia, "Somalia", "Flags"),
//            IconToken("ic_flags_somaliland", Icons.Flags.somaliland, "Somaliland", "Flags"),
//            IconToken("ic_flags_south_africa", Icons.Flags.southAfrica, "South Africa", "Flags"),
//            IconToken("ic_flags_south_ossetia", Icons.Flags.southOssetia, "South Ossetia", "Flags"),
//            IconToken("ic_flags_spain", Icons.Flags.spain, "Spain", "Flags"),
//            IconToken("ic_flags_united_kingdom", Icons.Flags.unitedKingdom, "United Kingdom", "Flags"),
//            IconToken("ic_flags_united_states", Icons.Flags.unitedStates, "United States", "Flags"),
//            IconToken("ic_flags_uruguay", Icons.Flags.uruguay, "Uruguay", "Flags"),
//            IconToken("ic_flags_venezuela", Icons.Flags.venezuela, "Venezuela", "Flags")
        )
        
        return categories
    }
}

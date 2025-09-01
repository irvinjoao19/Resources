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
        
        // Flags icons (most important countries) - ALL FLAGS
        categories["Flags"] = mutableListOf(
            IconToken("ic_flags_peru", Icons.Flags.peru, "ic_flags_peru", "Flags"),
            IconToken("ic_flags_mexico", Icons.Flags.mexico, "ic_flags_mexico", "Flags"),
            IconToken("ic_flags_colombia", Icons.Flags.colombia, "ic_flags_colombia", "Flags"),
            IconToken("ic_flags_argentina", Icons.Flags.argentina, "ic_flags_argentina", "Flags"),
            IconToken("ic_flags_chile", Icons.Flags.chile, "ic_flags_chile", "Flags"),
            IconToken("ic_flags_brazil", Icons.Flags.brazil, "ic_flags_brazil", "Flags"),
            IconToken("ic_flags_ecuador", Icons.Flags.ecuador, "ic_flags_ecuador", "Flags"),
            IconToken("ic_flags_bolivia", Icons.Flags.bolivia, "ic_flags_bolivia", "Flags"),
            IconToken("ic_flags_venezuela", Icons.Flags.venezuela, "ic_flags_venezuela", "Flags"),
            IconToken("ic_flags_uruguay", Icons.Flags.uruguay, "ic_flags_uruguay", "Flags"),
            IconToken("ic_flags_paraguay", Icons.Flags.paraguay, "ic_flags_paraguay", "Flags"),
            IconToken("ic_flags_france", Icons.Flags.france, "ic_flags_france", "Flags"),
            IconToken("ic_flags_germany", Icons.Flags.germany, "ic_flags_germany", "Flags"),
            IconToken("ic_flags_italy", Icons.Flags.italy, "ic_flags_italy", "Flags"),
            IconToken("ic_flags_spain", Icons.Flags.spain, "ic_flags_spain", "Flags"),
            IconToken("ic_flags_united_kingdom", Icons.Flags.unitedKingdom, "ic_flags_united_kingdom", "Flags"),
            IconToken("ic_flags_united_states", Icons.Flags.unitedStates, "ic_flags_united_states", "Flags"),
            IconToken("ic_flags_canada", Icons.Flags.canada, "ic_flags_canada", "Flags"),
            IconToken("ic_flags_russia", Icons.Flags.russia, "ic_flags_russia", "Flags")
        )
        
        return categories
    }
}

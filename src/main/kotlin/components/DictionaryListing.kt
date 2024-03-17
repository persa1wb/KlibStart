package components

import model.*
import react.FC
import react.Key
import react.Props
import react.dom.html.ReactHTML.div

external interface DictionaryListingProps : Props {
    var term: TermRecord
    var usages: Array<UsageRecord>
}

val DictionaryListing = FC<DictionaryListingProps> {props ->
    var x: MutableMap<DefinitionRecord, DictionaryEntryProps> = mutableMapOf()

    props.usages.forEach {
        var dep: DictionaryEntryProps? = null
        if (x.containsKey(it.definition)) {
            dep = x.get(it.definition)
        }
        if (dep == null) {
            dep = object : DictionaryEntryProps {
                override var key: Key? = "0"
                override var definition = it.definition
                override var audienceContexts: Array<DictionaryEntryAudienceContext> = arrayOf()
            }
            x.set(it.definition, dep)
        }
        dep.audienceContexts = dep.audienceContexts.plus(object : DictionaryEntryAudienceContext {
            override var audience: AudienceRecord = it.audience
            override var context: ContextRecord = it.context
        })
    }

    div {
        +"${props.term.term}"
        x.map {
            DictionaryEntry {
                definition = it.key
                audienceContexts = it.value.audienceContexts
            }
        }
    }
}
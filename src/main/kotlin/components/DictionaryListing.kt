package components

import model.AudienceRecord
import model.ContextRecord
import model.DefinitionRecord
import model.TermRecord
import model.UsageRecord
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.*

interface DictionaryListingProps : Props {
    var term: TermRecord
    var usages: Array<UsageRecord>
}

val DictionaryListing = FC<DictionaryListingProps> {
    var x: MutableMap<DefinitionRecord, DictionaryEntryProps> = mutableMapOf()

    it.usages.forEach {
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

    ReactHTML.div {
        +"${it.term.term}"
        x.map {
            DictionaryEntry {
                definition = it.key
                audienceContexts = it.value.audienceContexts
            }
        }
    }
}
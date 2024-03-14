package model

interface TermRecord {
    var term: String
}

interface DefinitionRecord {
    var partOfSpeech: String
    var definition: String
}

interface AudienceRecord {
    var name: String
}

interface ContextRecord {
    var name: String
}
// Not all terms should need a specific context, so a general context is available.
var ContextRecordGeneral = object : ContextRecord {
    override var name = "General"
}

interface UsageRecord {
    var term: TermRecord
    var audience: AudienceRecord
    var context: ContextRecord
    var definition: DefinitionRecord
}

var TermRecordRun = object : TermRecord {
    override var term = "run"
}

var ContextRecordTacoTuesday = object : ContextRecord {
    override var name = "taco tuesday"
}

var AudienceRecordDevelopers = object : AudienceRecord {
    override var name = "developers"
}
var AudienceRecordGymTeachers = object : AudienceRecord {
    override var name = "gym teachers"
}

var DefinitionRecordRunWithLegs = object : DefinitionRecord {
    override var partOfSpeech = "verb"
    override var definition = "to move your legs quickly in sync for the purpose of ambulating faster than typical"
}
var DefinitionRecordRunOfAnApplication = object : DefinitionRecord {
    override var partOfSpeech = "noun"
    override var definition = "the completed execution of an software application; it's output and/or it's results"
}
var DefinitionRecordRunAnApplication = object : DefinitionRecord {
    override var partOfSpeech = "verb"
    override var definition = "to start or initiate a software application"
}

fun getUsageRecords(): Array<UsageRecord> {
    return arrayOf(
        object : UsageRecord {
            override var term = TermRecordRun
            override var audience = AudienceRecordDevelopers
            override var context = ContextRecordGeneral
            override var definition = DefinitionRecordRunAnApplication
        },
        object : UsageRecord {
            override var term = TermRecordRun
            override var audience = AudienceRecordDevelopers
            override var context = ContextRecordGeneral
            override var definition = DefinitionRecordRunOfAnApplication
        },
        object : UsageRecord {
            override var term = TermRecordRun
            override var audience = AudienceRecordDevelopers
            override var context = ContextRecordTacoTuesday
            override var definition = DefinitionRecordRunWithLegs
        },
        object : UsageRecord {
            override var term = TermRecordRun
            override var audience = AudienceRecordGymTeachers
            override var context = ContextRecordGeneral
            override var definition = DefinitionRecordRunWithLegs
        },
    )
}

fun getUsageRecords(term: TermRecord): Array<UsageRecord> {
    return getUsageRecords().filter {
        it.term == term
    }.toTypedArray()
}
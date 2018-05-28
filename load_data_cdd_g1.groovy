import java.text.SimpleDateFormat

config load_new: true, create_schema: true

path = '/opt/data/'

def entity = File.text(path + "entity.csv").delimiter(",").header("entityId", "entityIdType", "entityType")

def group = File.text(path + "group.csv").delimiter(",").header("groupId", "groupIdType", "groupType")

def account = File.text(path + "account.csv").delimiter(",").header("accountUniqueId", "accountNumber")

def member = File.text(path + "member.csv").delimiter(",").header("entityId", "groupId", "isHead")

def relation = File.text(path + "relation.csv").delimiter(",").header("entityId", "entityId", "rrId", "type")

def belongs = File.text(path + "/belongs/belongs.csv").delimiter(",").header("accountUniqueId", "groupId", "startDate")

def belongInput = belongs.map{ it['startDate'] = Date.parse("yyyy-MM-dd hh:mm:ss", it['startDate']); it}

load(entity).asVertices {
    label "Entity"
    key "entityId"
	ignore "entityIdType"
	ignore "entityType"
}

load(group).asVertices {
    label "Group"
    key "groupId"
	ignore "groupIdType"
	ignore "groupType"
}

load(account).asVertices {
    label "Account"
    key "accountUniqueId"
	ignore "accountNumber"	
}

load(member).asEdges {
    isNew()
    label "Member"
    outV "entityId", {
        exists()
        label "Entity"
        key "entityId"
    }
    inV "groupId", {
        exists()
        label "Group"
        key "groupId"
    }
}

load(relation).asEdges {
    isNew()
    label "Relationship"
    outV "entityId", {
        exists()
        label "Entity"
        key "entityId"
    }
    inV "entityId", {
        exists()
        label "Entity"
        key "entityId"
    }
}

load(belongInput).asEdges {
    isNew()
    label "Belongs"
    outV "accountUniqueId", {
        exists()
        label "Account"
        key "accountUniqueId"
    }
    inV "groupId", {
        exists()
        label "Group"
        key "groupId"
    }
}

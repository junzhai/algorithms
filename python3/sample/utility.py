def p(topic, sub_topic : str, example) -> bool:
    if len(sub_topic) > 0:
        print(f"{topic} : {sub_topic} --> {example}")
    else:
        print(f"{topic} --> {example}")
    return True

class Goal_Parser_Interpretation:
    def interpret(self, command: str) -> str:
        return command.replace("()","o").replace("(al)", "al")
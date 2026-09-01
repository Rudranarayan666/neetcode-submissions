class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded = ""

        for s in strs:
            encoded += str(len(s)) + "#" + s

        return encoded

    def decode(self, s: str) -> List[str]:
        result = []
        i = 0

        while i < len(s):
            # Find the '#' separating length from string
            j = i

            while s[j] != "#":
                j += 1

            # Parse the length
            length = int(s[i:j])

            # Start of actual string
            start = j + 1

            # Extract exactly `length` characters
            result.append(s[start:start + length])

            # Move to the next encoded string
            i = start + length

        return result

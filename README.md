# RDFrules notebooks

TODO popis instalace Scaly a Almondu

```
import com.github.propi.rdfrules.rule.Amie -> import com.github.propi.rdfrules.algorithm.amie.Amie
import com.github.propi.rdfrules.rule.Debugger -> import com.github.propi.rdfrules.utils.Debugger


Amie().addConstraint(RuleConstraint.ConstantsAtPosition(RuleConstraint.ConstantsAtPosition.ConstantsPosition.Object))

.computeLift()
.sortBy(Measure.HeadCoverage, Measure.Lift)
```

# rules

```
(?a <hasGender> <female>) ^ (?b <isMarriedTo> ?a) -> (?a <isMarriedTo> ?b) | support: 5, headCoverage: 0.02564102564102564, confidence: 1.0, pcaConfidence: 1.0, lift: 75.8917525773196, headConfidence: 0.01317666236500713, headSize: 195, bodySize: 5, pcaBodySize: 5, cluster: 0
(?b <isMarriedTo> ?a) ^ (?a <hasGender> <male>) -> (?a <isMarriedTo> ?b) | support: 7, headCoverage: 0.035897435897435895, confidence: 1.0, pcaConfidence: 1.0, lift: 75.8917525773196, headConfidence: 0.01317666236500713, headSize: 195, bodySize: 7, pcaBodySize: 7, cluster: 1
(?b <isMarriedTo> ?a) ^ (?a <isCitizenOf> <Scotland>) -> (?a <isMarriedTo> ?b) | support: 4, headCoverage: 0.020512820512820513, confidence: 1.0, pcaConfidence: 1.0, lift: 75.8917525773196, headConfidence: 0.01317666236500713, headSize: 195, bodySize: 4, pcaBodySize: 4, cluster: 2
(?b <isMarriedTo> ?a) ^ (?a <isCitizenOf> <Netherlands>) -> (?a <isMarriedTo> ?b) | support: 4, headCoverage: 0.020512820512820513, confidence: 1.0, pcaConfidence: 1.0, lift: 75.8917525773196, headConfidence: 0.01317666236500713, headSize: 195, bodySize: 4, pcaBodySize: 4, cluster: 2
(?a <isCitizenOf> <Canada>) ^ (?b <isMarriedTo> ?a) -> (?a <isMarriedTo> ?b) | support: 4, headCoverage: 0.020512820512820513, confidence: 1.0, pcaConfidence: 1.0, lift: 75.8917525773196, headConfidence: 0.01317666236500713, headSize: 195, bodySize: 4, pcaBodySize: 4, cluster: 2
(?b <isMarriedTo> ?a) ^ (?a <isCitizenOf> <United_Kingdom>) -> (?a <isMarriedTo> ?b) | support: 5, headCoverage: 0.02564102564102564, confidence: 1.0, pcaConfidence: 1.0, lift: 75.8917525773196, headConfidence: 0.01317666236500713, headSize: 195, bodySize: 5, pcaBodySize: 5, cluster: 2
(?b <isMarriedTo> ?a) ^ (?a <isCitizenOf> <Germany>) -> (?a <isMarriedTo> ?b) | support: 6, headCoverage: 0.03076923076923077, confidence: 1.0, pcaConfidence: 1.0, lift: 75.8917525773196, headConfidence: 0.01317666236500713, headSize: 195, bodySize: 6, pcaBodySize: 6, cluster: 2
(?b <isMarriedTo> ?a) ^ (?a <isCitizenOf> <England>) -> (?a <isMarriedTo> ?b) | support: 7, headCoverage: 0.035897435897435895, confidence: 1.0, pcaConfidence: 1.0, lift: 75.8917525773196, headConfidence: 0.01317666236500713, headSize: 195, bodySize: 7, pcaBodySize: 7, cluster: 2
(?a <isCitizenOf> <United_States>) ^ (?b <isMarriedTo> ?a) -> (?a <isMarriedTo> ?b) | support: 8, headCoverage: 0.041025641025641026, confidence: 1.0, pcaConfidence: 1.0, lift: 75.8917525773196, headConfidence: 0.01317666236500713, headSize: 195, bodySize: 8, pcaBodySize: 8, cluster: 2
```

# Generate scaled 4*5 matrix with random std normal samples
set.seed(101)
d = matrix(rnorm(20), 4, 5)
mat <- scale(matrix(rnorm(20), 4, 5))
d
mat
dimnames(mat) <- list(paste("Sample", 1:4), paste("Var", 1:5))

# Perform PCA
myPCA <- prcomp(mat, scale. = F, center = F)
myPCA$rotation # loadings
myPCA$x # scores







wine <- read.table("http://archive.ics.uci.edu/ml/machine-learning-databases/wine/wine.data", sep=",")
head(wine)
# Name the variables
colnames(wine) <- c("Cvs","Alcohol","Malic acid","Ash","Alcalinity of ash", "Magnesium", "Total phenols", "Flavanoids", "Nonflavanoid phenols", "Proanthocyanins", "Color intensity", "Hue", "OD280/OD315 of diluted wines", "Proline")

# The first column corresponds to the classes
wineClasses <- factor(wine$Cvs)

withoutscalePCA <- prcomp(wine[,-1])

winePCA <- prcomp(scale(wine[,-1]))


par(mfrow = c(3,2) )
par(mfrow = c(3,2) )
plot(wine[,2], col = wineClasses)
plot(wine[,3], col = wineClasses)

#without scaling
plot(withoutscalePCA $x[,1], col = wineClasses)
plot(withoutscalePCA $x[,2], col = wineClasses)
#with scaling

plot(winePCA $x[,1], col = wineClasses)
plot(winePCA $x[,2], col = wineClasses)

